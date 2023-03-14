FROM amazoncorretto:17.0.3-alpine as corretto-jdk
RUN apk add --no-cache binutils
RUN ${JAVA_HOME}/bin/jlink \
    --verbose \
    --add-modules ALL-MODULE-PATH \
    --strip-debug \
    --no-man-pages \
    --no-header-files \
    --compress=2 \
    --output /customjre


FROM alpine:latest
ENV JAVA_HOME=/jre
ENV PATH="${JAVA_HOME}/bin:${PATH}"
COPY --from=corretto-jdk /customjre $JAVA_HOME
ARG SERVICE_NAME
ENV SERVICE_NAME=${SERVICE_NAME}
ARG EUREKA_URI 
ENV SERVICE_NAME=${SERVICE_NAME}
ENV EUREKA_URI=${EUREKA_URI:-http://eureka-server:8761/eureka/}
ARG TZ
ENV TZ=${TZ:-Europe/Paris}
ARG SPRING_PROFILES_ACTIVE
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE:-docker}
COPY ./${SERVICE_NAME}-1.0-SNAPSHOT.jar /usr/local/bin/artifact.jar
ENTRYPOINT [ "/jre/bin/java", "-jar", "/usr/local/bin/artifact.jar" ]

EXPOSE 8080
