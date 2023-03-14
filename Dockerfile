ARG SERVICE_NAME


FROM scratch AS package-rabbitmq
COPY ./rabbitmq-1.0-SNAPSHOT.jar /target/rabbitmq-1.0-SNAPSHOT.jar
# COPY ./services/infra/rabbitmq/target/rabbitmq-1.0-SNAPSHOT.jar /target/rabbitmq-1.0-SNAPSHOT.jar


FROM scratch AS package-eureka-server
COPY ./eureka-server-1.0-SNAPSHOT.jar /target/eureka-server-1.0-SNAPSHOT.jar


FROM scratch AS package-gateway
COPY ./gateway-1.0-SNAPSHOT.jar /target/gateway-1.0-SNAPSHOT.jar


FROM scratch AS package-customer
COPY ./customer-1.0-SNAPSHOT-exec.jar /target/customer-1.0-SNAPSHOT.jar


FROM scratch AS package-store
COPY ./store-1.0-SNAPSHOT-exec.jar /target/store-1.0-SNAPSHOT.jar


FROM scratch AS package-product
COPY ./product-1.0-SNAPSHOT.jar /target/product-1.0-SNAPSHOT.jar


FROM scratch AS package-cusomisation
COPY ./customisation-1.0-SNAPSHOT.jar /target/customisation-1.0-SNAPSHOT.jar


FROM scratch AS package-subscription
COPY ./subscription-1.0-SNAPSHOT.jar /target/subscription-1.0-SNAPSHOT.jar


FROM scratch AS package-ticket
COPY ./ticket-1.0-SNAPSHOT.jar /target/ticket-1.0-SNAPSHOT.jar


FROM scratch AS package-notification
COPY ./notification-1.0-SNAPSHOT.jar /target/notification-1.0-SNAPSHOT.jar


FROM scratch AS package-order
COPY ./order-1.0-SNAPSHOT.jar /target/order-1.0-SNAPSHOT.jar


FROM scratch AS package-authentication
COPY ./authentication-1.0-SNAPSHOT.jar /target/authentication-1.0-SNAPSHOT.jar


FROM package-${SERVICE_NAME} AS package-final


FROM openjdk:17-alpine AS runtime
ARG SERVICE_NAME
ENV SERVICE_NAME=${SERVICE_NAME}
ARG EUREKA_URI 
ENV SERVICE_NAME=${SERVICE_NAME}
ENV EUREKA_URI=${EUREKA_URI:-http://eureka-server:8761/eureka/}
ARG TZ
ENV TZ=${TZ:-Europe/Paris}
ARG SPRING_PROFILES_ACTIVE
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE:-docker}
COPY --from=package-final /target/${SERVICE_NAME}-1.0-SNAPSHOT.jar /usr/local/bin/artifact.jar
ENTRYPOINT [ "java", "-jar", "/usr/local/bin/artifact.jar" ]
