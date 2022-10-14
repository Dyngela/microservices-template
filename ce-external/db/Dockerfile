FROM postgres:14.3-alpine
COPY ./dbinit/* ./docker-entrypoint-initdb.d/
RUN chmod -R +x ./docker-entrypoint-initdb.d
COPY ./postgres.sh .
