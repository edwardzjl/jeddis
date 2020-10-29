-- Using Spring Data R2DBC, tables cannot be created at runtime. We need to create them manually.

-- ensure extension for uuid is installed
create extension if not exists "uuid-ossp";

-- create post table
create table if not exists post (
    id uuid primary key default uuid_generate_v1(),
    author uuid,
    reply_to uuid,
    title text,
    content text,
    create_time timestamp,
    update_time timestamp
);
