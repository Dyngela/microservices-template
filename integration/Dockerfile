FROM python:3.11.2-slim-bullseye
ARG API_URI
ENV API_URI=${API_URI}
WORKDIR /integration
COPY . /integration
RUN python3 -m pip install --no-cache-dir \
    virtualenv \
    setuptools \
    build
RUN python3 -m virtualenv .venv
RUN .venv/bin/python -m pip install --no-cache-dir -r requirements.txt
ENTRYPOINT [ "/integration/.venv/bin/python", "/integration/main.py" ]
