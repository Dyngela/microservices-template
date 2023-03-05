create table if not exists notification (
     notification_id serial not null,
     customer_id int8 not null,
     message varchar(255) not null,
     phone_number varchar(255) not null,
     created_at timestamp not null,
     deleted_at timestamp,
     updated_at timestamp,
    primary key (notification_id)
);
