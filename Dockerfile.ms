ARG SERVICE_NAME

FROM ce-base:latest as builder


FROM amazoncorretto:17-alpine3.13 AS runtime
ENV SRC=/opt/project
ARG SERVICE_NAME
ENV SERVICE_NAME=${SERVICE_NAME}
COPY --from=builder ${SRC}/${SERVICE_NAME}.jar /usr/local/bin/artifact.jar
ENV EUREKA_URI=${EUREKA_URI:-http://eureka-server:8761/eureka/}
ENV TZ=${TZ:-Europe/Paris}
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE:-docker}
# ENV spring_profiles_active=${spring_profiles_active:-docker}
# COPY --from=builder /data /data
ENTRYPOINT [ "java", "-jar", "/usr/local/bin/artifact.jar" ]
