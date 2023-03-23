create table if not exists ticket (
    ticket_id serial not null,
    title varchar not null,
    problem_type varchar not null,
    description varchar not null,
    sender_type varchar not null,
    state varchar not null,
    created_at timestamp not null,
    deleted_at timestamp,
    updated_at timestamp,
    store_id int8,
    customer_id int8,

    primary key (ticket_id)
);
