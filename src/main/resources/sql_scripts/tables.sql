-- CREATE museum_rooms TABLE
drop table museum_rooms;

create table museum_rooms
(
    id           bigserial not null
        constraint museum_rooms_pkey
            primary key,
    description  text,
    map_position varchar(255),
    room_id      bigint,
    title        varchar(255),
    tour_name    varchar(255)
);

alter table museum_rooms
    owner to postgres;

-----------------------------------------
-- CREATE media_files TABLE
drop table media_files;

create table media_files
(
    file_id   bigserial not null
        constraint media_files_pkey
            primary key,
    file_data bytea,
    file_name varchar(255),
    file_type varchar(255),
    room_id   bigint
        constraint fkh2j1ckb1f9n258uthemr21n0f
            references museum_rooms
);

alter table media_files
    owner to postgres;