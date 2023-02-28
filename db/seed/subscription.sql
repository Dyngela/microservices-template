-- noinspection SqlNoDataSourceInspectionForFile

create table if not exists subscription (
                                            subscription_id serial not null,
                                            date_start timestamp,
                                            date_end timestamp,
                                            payment_type varchar,
                                            store_id int8,
                                            subscription_type_id int8,

                                            created_at timestamp not null,
                                            deleted_at timestamp,
                                            updated_at timestamp,

                                            primary key(subscription_id)
);

create table if not exists subscription_type (
                                                 subscription_type_id serial not null,
                                                 name varchar,
                                                 turnover numeric(15,2),
                                                 support varchar,
                                                 price numeric(8,2),

                                                 created_at timestamp not null,
                                                 deleted_at timestamp,
                                                 updated_at timestamp,

                                                 primary key(subscription_type_id)
);

alter table if exists subscription add constraint subscription_has_type foreign key (subscription_type_id) references subscription_type;

insert into subscription_type values (1, 'Bronze', '15000', 'low', 70.00, now(), null, null);
insert into subscription_type values (2, 'Silver', '30000', 'medium', 140.00, now(), null, null);
insert into subscription_type values (3, 'Gold', '45000', 'high', 210.00, now(), null, null);
insert into subscription_type values (4, 'Premium', '100000', 'must', 300.00, now(), null, null);
