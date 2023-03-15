FROM postgres:14.3-alpine
COPY 01-init.sh /docker-entrypoint-initdb.d/01-init.sh
COPY seed /seed
ARG TZ
ENV TZ=${TZ:-Europe/Paris}
ARG PGTZ
ENV PGTZ=${PGTZ:-Europe/Paris}
ARG PGDATA
ENV PGDATA=${PGDATA:-/data/postgres}
RUN chmod -R +x /docker-entrypoint-initdb.d
