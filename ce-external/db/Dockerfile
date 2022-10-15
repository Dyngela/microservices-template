FROM postgres:14.3-alpine
COPY ./01-init.sh /docker-entrypoint-initdb.d/
RUN chmod -R +x ./docker-entrypoint-initdb.d
COPY ./seed /seed
#COPY ./postgres.sh .
