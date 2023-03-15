FROM yulquen/cande-builder:latest
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
