create table if not exists customisation (
     customisation_id serial not null,
     color_background varchar not null,
     color_button varchar not null,
     font varchar not null unique,
     catch_phrase varchar not null,
     active boolean,
     created_at timestamp not null,
     deleted_at timestamp,
     updated_at timestamp,
     store_id int8 not null,
     primary key (customisation_id)
);
