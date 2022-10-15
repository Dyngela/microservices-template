#!/bin/sh

create_db() {
  [ -z "$1" ] && return 1
  psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_USER" -c "CREATE DATABASE $1 template=template0 OWNER $POSTGRES_USER;"
  psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_USER" -c "GRANT ALL PRIVILEGES ON DATABASE $1 TO $POSTGRES_USER;"
}

seed_db() {
  [ -z "$1" ] && return 1
  [ -f /seed/"$1".sql ] && psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$1" -f /seed/"$1".sql
}

create_db authentication 
seed_db authentication 
create_db store 
seed_db store 
create_db customisation 
seed_db customisation 
create_db payment
seed_db payment
create_db subscription
seed_db subscription
create_db ticket
seed_db ticket
create_db customer
seed_db customer
create_db notification
seed_db notification
create_db orders
seed_db orders
create_db product
seed_db product

