ARG SERVICE_NAME


FROM openjdk:17-alpine as builder
RUN apk add --update-cache \
    ncdu \
    python3 \
    git \
    wget \
    maven \
  && rm -rf /var/cache/apk/*
ENV SRC=/usr/project
WORKDIR ${SRC}


FROM builder AS tier0
ENV SPRING_PROFILES_ACTIVE=docker
ADD pom.xml ${SRC}
ADD services/infra/gateway/pom.xml ${SRC}/services/infra/gateway/pom.xml
ADD services/infra/eureka-server/pom.xml ${SRC}/services/infra/eureka-server/pom.xml
ADD services/infra/config-server/pom.xml ${SRC}/services/infra/config-server/pom.xml
ADD services/infra/rabbitMQ/pom.xml ${SRC}/services/infra/rabbitMQ/pom.xml

ADD services/back-office/customisation/pom.xml ${SRC}/services/back-office/customisation/pom.xml
ADD services/back-office/payment/pom.xml ${SRC}/services/back-office/payment/pom.xml
ADD services/back-office/subscription/pom.xml ${SRC}/services/back-office/subscription/pom.xml
ADD services/back-office/ticket/pom.xml ${SRC}/services/back-office/ticket/pom.xml

ADD services/core/authentication/pom.xml ${SRC}/services/core/authentication/pom.xml
ADD services/core/clients/pom.xml ${SRC}/services/core/clients/pom.xml
ADD services/core/customer/pom.xml ${SRC}/services/core/customer/pom.xml
ADD services/core/notification/pom.xml ${SRC}/services/core/notification/pom.xml
ADD services/core/order/pom.xml ${SRC}/services/core/order/pom.xml
ADD services/core/product/pom.xml ${SRC}/services/core/product/pom.xml
ADD services/core/store/pom.xml ${SRC}/services/core/store/pom.xml

RUN mvn verify --fail-never


FROM tier0 AS build-rabbitmq
RUN mvn verify --fail-never -pl rabbitmq
ADD services/infra/rabbitMQ ${SRC}/services/infra/rabbitMQ
RUN mvn install -pl com.diy:rabbitMQ


FROM build-rabbitmq AS package-rabbitmq
COPY --from=build-rabbitmq ${SRC}/services/infra/rabbitmq/target/rabbitmq-1.0-SNAPSHOT.jar /target/rabbitmq-1.0-SNAPSHOT.jar
RUN mkdir /data


FROM tier0 AS build-eureka-server
RUN mvn verify --fail-never -pl eureka-server
ADD services/infra/eureka-server ${SRC}/services/infra/eureka-server
RUN mvn package -pl com.diy:eureka-server


FROM build-eureka-server AS package-eureka-server
COPY --from=build-eureka-server ${SRC}/services/infra/eureka-server/target/eureka-server-1.0-SNAPSHOT.jar /target/eureka-server-1.0-SNAPSHOT.jar
RUN mkdir /data


FROM tier0 AS build-config-server
RUN mvn verify --fail-never -pl config-server
ADD services/infra/config-server ${SRC}/services/infra/config-server
RUN mvn package -pl com.diy:config-server


FROM build-config-server AS package-config-server
COPY --from=build-config-server ${SRC}/services/infra/config-server/target/config-server-1.0-SNAPSHOT.jar /target/config-server-1.0-SNAPSHOT.jar
COPY --from=build-config-server ${SRC}/services/infra/config-server/src/main/resources/config /data


FROM tier0 AS build-gateway
RUN mvn verify --fail-never -pl gateway
ADD services/infra/gateway ${SRC}/services/infra/gateway
RUN mvn package -pl com.diy:gateway


FROM build-gateway AS package-gateway
COPY --from=build-gateway ${SRC}/services/infra/gateway/target/gateway-1.0-SNAPSHOT.jar /target/gateway-1.0-SNAPSHOT.jar
RUN mkdir /data


FROM tier0 AS build-customer
RUN mvn verify --fail-never -pl customer
ADD services/core/customer ${SRC}/services/core/customer
RUN mvn package -pl com.diy:customer


FROM build-customer AS package-customer
COPY --from=build-customer ${SRC}/services/core/customer/target/store-1.0-SNAPSHOT.jar /target/customer-1.0-SNAPSHOT.jar
RUN mkdir /data


FROM tier0 AS build-store
RUN mvn verify --fail-never -pl store
ADD services/core/store ${SRC}/services/core/store
RUN mvn package -pl com.diy:store


FROM build-store AS package-store
COPY --from=build-store ${SRC}/services/core/store/target/store-1.0-SNAPSHOT.jar /target/store-1.0-SNAPSHOT.jar
RUN mkdir /data


FROM tier0 AS tier1
COPY --from=build-rabbitmq ${SRC}/services/infra/rabbitMQ ${SRC}/services/infra/rabbitMQ
COPY --from=build-rabbitmq ${SRC}/services/infra/rabbitMQ/target/rabbitMQ-1.0-SNAPSHOT.jar /target/rabbitMQ-1.0-SNAPSHOT.jar
COPY --from=build-eureka-server ${SRC}/services/infra/eureka-server ${SRC}/services/infra/eureka-server
COPY --from=build-eureka-server ${SRC}/services/infra/eureka-server/target/eureka-server-1.0-SNAPSHOT.jar /target/eureka-server-1.0-SNAPSHOT.jar
COPY --from=build-config-server ${SRC}/services/infra/config-server ${SRC}/services/infra/config-server
COPY --from=build-config-server ${SRC}/services/infra/config-server/target/config-server-1.0-SNAPSHOT.jar /target/config-server-1.0-SNAPSHOT.jar
COPY --from=build-gateway ${SRC}/services/infra/gateway ${SRC}/services/infra/gateway
COPY --from=build-gateway ${SRC}/services/infra/gateway/target/gateway-1.0-SNAPSHOT.jar /target/gateway-1.0-SNAPSHOT.jar
COPY --from=build-customer ${SRC}/services/core/customer ${SRC}/services/core/customer
COPY --from=build-customer ${SRC}/services/core/customer/target/customer-1.0-SNAPSHOT.jar /target/customer-1.0-SNAPSHOT.jar
COPY --from=build-store ${SRC}/services/core/store ${SRC}/services/core/store
COPY --from=build-store ${SRC}/services/core/store/target/store-1.0-SNAPSHOT.jar /target/store-1.0-SNAPSHOT.jar


FROM tier1 AS build-clients
RUN mvn verify --fail-never -pl clients
ADD services/core/clients ${SRC}/services/core/clients
RUN mvn package -pl com.diy:customer,com.diy:store,com.diy:clients


FROM build-clients AS package-clients


FROM tier1 AS build-notification
RUN mvn verify --fail-never -pl notification
ADD services/core/notification ${SRC}/services/core/notification
RUN mvn package -pl com.diy:notification --also-make


FROM build-notification AS package-notification
COPY --from=build-notification ${SRC}/services/core/notification/target/notification-1.0-SNAPSHOT.jar /target/notification-1.0-SNAPSHOT.jar
RUN mkdir /data


FROM tier1 AS build-order
RUN mvn verify --fail-never -pl order
ADD services/core/order ${SRC}/services/core/order
RUN mvn package -pl com.diy:order --also-make


FROM build-order AS package-order
COPY --from=build-order ${SRC}/services/core/order/target/order-1.0-SNAPSHOT.jar /target/order-1.0-SNAPSHOT.jar
RUN mkdir /data


FROM tier1 AS tier2
COPY --from=build-clients ${SRC}/services/core/clients ${SRC}/services/core/clients
COPY --from=build-notification ${SRC}/services/core/notification ${SRC}/services/core/notification
COPY --from=build-order ${SRC}/services/core/order ${SRC}/services/core/order
COPY --from=build-authentication ${SRC}/services/core/authentication ${SRC}/services/core/authentication


FROM tier2 AS build-authentication
RUN mvn verify --fail-never -pl authentication
ADD services/core/authentication ${SRC}/services/core/authentication
RUN mvn package -pl com.diy:authentication --also-make


FROM build-authentication AS package-authentication
COPY --from=build-authentication ${SRC}/services/core/authentication/target/authentication-1.0-SNAPSHOT.jar /target/authentication-1.0-SNAPSHOT.jar
RUN mkdir /data


FROM package-${SERVICE_NAME} AS package-final


FROM openjdk:17-alpine AS runtime
ARG SERVICE_NAME
ENV SERVICE_NAME=${SERVICE_NAME}
ENV EUREKA_URI=${EUREKA_URI:-http://eureka-server:8761/eureka/}
ENV TZ=${TZ:-Europe/Paris}
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE:-docker}
COPY --from=package-final /target/${SERVICE_NAME}-1.0-SNAPSHOT.jar /usr/local/bin/artifact.jar
COPY --from=package-final /data /data
ENTRYPOINT [ "java", "-jar", "/usr/local/bin/artifact.jar" ]
