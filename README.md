## Collect&verything

### Tooling

In order to run the project in development mode you will need several tools:

* A JDK for Java, we use version 17 of OpenJDK (https://openjdk.org/)
* Maven, we use version 3.8.6 (https://maven.apache.org/)
* Docker (https://docs.docker.com/engine/install/)

####

### Getting started

This project use Open API to generate controllers and DTO based on a yml file at the root of each microservice.  
To get started you need to generate those. Just type the following command:

```shell
    mvn clean package -U
```

Now you will need to get databases up and running so as RabbitMQ. Easy way is to run our docker compose. at the root
of the project and in a shell with docker up and running type:

```shell
    docker compose up
```

If everything ran smoothly you will be able to have our backend up and running.
