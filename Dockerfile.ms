ARG SERVICE_NAME

FROM ce-base:latest as builder


FROM amazoncorretto:17-alpine3.13 AS runtime
ENV SRC=/opt/project
ARG SERVICE_NAME
ENV SERVICE_NAME=${SERVICE_NAME}
COPY --from=builder ${SRC}/${SERVICE_NAME}.jar /usr/local/bin/artifact.jar
# COPY --from=builder /data /data
ENTRYPOINT [ "java", "-jar", "/usr/local/bin/artifact.jar" ]
