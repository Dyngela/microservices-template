ARG SERVICE_NAME

FROM scratch
# COPY --from=build-rabbitmq ${SRC}/services/infra/rabbitmq/target/rabbitmq-1.0-SNAPSHOT.jar /target/rabbitmq-1.0-SNAPSHOT.jar
# COPY --from=build-eureka-server ${SRC}/services/infra/eureka-server/target/eureka-server-1.0-SNAPSHOT.jar /target/eureka-server-1.0-SNAPSHOT.jar
# COPY --from=build-gateway ${SRC}/services/infra/gateway/target/gateway-1.0-SNAPSHOT.jar /target/gateway-1.0-SNAPSHOT.jar
# COPY --from=build-customer ${SRC}/services/core/customer/target/customer-1.0-SNAPSHOT-exec.jar /target/customer-1.0-SNAPSHOT.jar
# COPY --from=build-store ${SRC}/services/core/store/target/store-1.0-SNAPSHOT-exec.jar /target/store-1.0-SNAPSHOT.jar
# COPY --from=build-product ${SRC}/services/core/product/target/product-1.0-SNAPSHOT.jar /target/product-1.0-SNAPSHOT.jar
# COPY --from=build-customisation ${SRC}/services/back-office/customisation/target/customisation-1.0-SNAPSHOT.jar /target/customisation-1.0-SNAPSHOT.jar
# COPY --from=build-subscription ${SRC}/services/back-office/subscription/target/subscription-1.0-SNAPSHOT.jar /target/subscription-1.0-SNAPSHOT.jar
# COPY --from=build-ticket ${SRC}/services/back-office/ticket/target/ticket-1.0-SNAPSHOT.jar /target/ticket-1.0-SNAPSHOT.jar
# COPY --from=build-notification ${SRC}/services/core/notification/target/notification-1.0-SNAPSHOT.jar /target/notification-1.0-SNAPSHOT.jar
# COPY --from=build-order ${SRC}/services/core/order/target/order-1.0-SNAPSHOT.jar /target/order-1.0-SNAPSHOT.jar
# COPY --from=build-authentication ${SRC}/services/core/authentication/target/authentication-1.0-SNAPSHOT.jar /target/authentication-1.0-SNAPSHOT.jar

COPY ./services/infra/rabbitmq/target/rabbitmq-1.0-SNAPSHOT.jar /target/rabbitmq-1.0-SNAPSHOT.jar
COPY ./services/infra/eureka-server/target/eureka-server-1.0-SNAPSHOT.jar /target/eureka-server-1.0-SNAPSHOT.jar
COPY ./services/infra/gateway/target/gateway-1.0-SNAPSHOT.jar /target/gateway-1.0-SNAPSHOT.jar
COPY ./services/core/customer/target/customer-1.0-SNAPSHOT-exec.jar /target/customer-1.0-SNAPSHOT.jar
COPY ./services/core/store/target/store-1.0-SNAPSHOT-exec.jar /target/store-1.0-SNAPSHOT.jar
COPY ./services/core/product/target/product-1.0-SNAPSHOT.jar /target/product-1.0-SNAPSHOT.jar
COPY ./services/back-office/customisation/target/customisation-1.0-SNAPSHOT.jar /target/customisation-1.0-SNAPSHOT.jar
COPY ./services/back-office/subscription/target/subscription-1.0-SNAPSHOT.jar /target/subscription-1.0-SNAPSHOT.jar
COPY ./services/back-office/ticket/target/ticket-1.0-SNAPSHOT.jar /target/ticket-1.0-SNAPSHOT.jar
COPY ./services/core/notification/target/notification-1.0-SNAPSHOT.jar /target/notification-1.0-SNAPSHOT.jar
COPY ./services/core/order/target/order-1.0-SNAPSHOT.jar /target/order-1.0-SNAPSHOT.jar
COPY ./services/core/authentication/target/authentication-1.0-SNAPSHOT.jar /target/authentication-1.0-SNAPSHOT.jar


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
