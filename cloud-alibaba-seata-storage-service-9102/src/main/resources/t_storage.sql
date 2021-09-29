create database if not exists storage_db;
use storage_db;

create table t_storage
(
    id         int auto_increment
        primary key,
    product_id int null,
    residue    int null
);

INSERT INTO storage_db.t_storage (id, product_id, residue) VALUES (1, 1, 100);