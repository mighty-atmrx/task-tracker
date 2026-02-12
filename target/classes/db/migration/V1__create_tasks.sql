create table task (
    id bigserial primary key,
    title varchar(256) not null,
    description varchar(256),
    status varchar(256)
);