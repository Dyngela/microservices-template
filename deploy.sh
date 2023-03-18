#!/usr/bin/env bash

set -o pipefail # trace ERR through pipes
set -o errtrace # trace ERR through 'time command' and other functions
set -o nounset  ## set -u : exit the script if you try to use an uninitialised variable
set -o errexit  ## set -e : exit the script if any statement returns a non-true return value

REMOTE=debian@collecteverything.fr # todo: change here
echo " * OPENING DOCKER SOCKET TUNNEL"
socat \
	"UNIX-LISTEN:/tmp/docker.sock,reuseaddr,fork" \
	"EXEC:'ssh -kTax $REMOTE sudo socat STDIO UNIX-CONNECT\:/var/run/docker.sock'" \
	&
export DOCKER_HOST=unix:///tmp/docker.sock
export COMPOSE_PROJECT_NAME=cande
echo " * LOGIN WITH GITLAB-CI TOKEN"
echo ${CI_REGISTRY_PASSWORD} | docker login -u ${CI_REGISTRY_USER} --password-stdin
echo " * PULLING NEW IMAGES"
docker compose -f compose.yaml -f compose.prod.yaml pull
echo " * UPDATING RUNNING CONTAINERS"
docker compose -f compose.yaml -f compose.prod.yaml up -d
echo " * CLEANING OLD IMAGES"
ssh -t debian@collecteverything.fr "sudo docker prune system -a"
