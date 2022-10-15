create table store.store (
     store_id serial not null,

     store_name varchar(255) not null unique,
     email varchar(255) not null unique,
     firstname varchar(255) not null,
     lastname varchar(255) not null,
     phone_number varchar(255) not null,
     sector varchar(255) not null,
     siret varchar(255) not null unique,

     created_at timestamp not null,
     deleted_at timestamp,
     updated_at timestamp,

     subscription_id int8,

     primary key (store_id)
);

create table store.address (
    address_id serial not null,

    city varchar(255) not null,
    complement varchar(255),
    postal_code varchar(255) not null,
    street_name varchar(255) not null,
    street_number varchar(255) not null,

    created_at timestamp not null,
    deleted_at timestamp,
    updated_at timestamp,

    store_id int8,
    primary key (address_id)
);

alter table if exists store.address add constraint address_has_store foreign key (store_id) references store.store;

insert into store.store values (1, 'Google',          'google@gmail.com',    'Tai',      'Mui',        '+90 678 443 223',   'Hardware', '8883999332', now(), null, null, 1);
insert into store.store values (2, 'Flower and co',   'flower@gmail.com',    'Erwan',    'Nutz',       '+33 7 70 17 98 18', 'Flower',   '3443443434', now(), null, null, 2);
insert into store.store values (3, 'Your food',       'your.food@gmail.com', 'Aymeric',  'Guth',       '+33 7 70 17 98 18', 'Aliments', '4355758778', now(), null, null, 1);
insert into store.store values (4, 'Leclerc small',   'leclerc@gmail.com',   'Mandy',    'Spigarelli', '+33 7 70 17 98 18', 'Aliments', '0876896788', now(), null, null, 3);
insert into store.store values (5, 'Rose and Jasmin', 'rosejasm@gmail.com',  'Matthieu', 'François',   '+33 7 70 17 98 18', 'Flower',   '1235432563', now(), now(), now(), 1);

insert into store.address values (1, 'San francisco', 'App 132', '94110', 'rue du grand Chêne', '32b', now(), null, null, 1);
insert into store.address values (2, 'Paris',          null,     '93000', 'rue de Paris',       '47',  now(), null, null, 2);
insert into store.address values (3, 'Nancy',          null,     '54000', 'rue de Nancy',       '77c', now(), null, null, 3);
insert into store.address values (4, 'Metz',           null,     '57000', 'rue de Metz',        '875', now(), now(), now(), 4);
insert into store.address values (5, 'Strasbourg',     null,     '67200', 'rue de Strasbourg',  '795', now(), null, null, 5);
insert into store.address values (6, 'Schiltigheim',   null,     '67300', 'rue de Schilik',     '521', now(), null, null, 4);
insert into store.address values (7, 'Bordeaux',       null,     '30072', 'rue de Bordeaux',    '634', now(), null, null, 5);