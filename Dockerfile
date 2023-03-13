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
ADD services/infra/rabbitMQ/pom.xml ${SRC}/services/infra/rabbitMQ/pom.xml

ADD services/back-office/customisation/pom.xml ${SRC}/services/back-office/customisation/pom.xml
# ADD services/back-office/payment/pom.xml ${SRC}/services/back-office/payment/pom.xml
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
