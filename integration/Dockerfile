# syntax=docker/dockerfile:1.4
ARG DOCKER_IMAGE

FROM $DOCKER_IMAGE AS base-layer
ARG PROJECT_NAME
ENV PROJECT_NAME=$PROJECT_NAME
ENV WORKSPACE=/$PROJECT_NAME
COPY . $WORKSPACE
WORKDIR $WORKSPACE


FROM base-layer AS stagging-common
RUN python3 -m pip install --no-cache-dir \
    virtualenv \
    setuptools \
    build
RUN python3 -m virtualenv .venv


FROM stagging-common AS stagging
RUN .venv/bin/python -m pip install --no-cache-dir -r requirements.txt
ENTRYPOINT [ "/integration/.venv/bin/python", "/integration/main.py" ]
