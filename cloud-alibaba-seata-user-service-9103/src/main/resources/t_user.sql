create database if not exists user_db;
use user_db;

create table t_user
(
    id      int auto_increment
        primary key,
    balance double null
);

INSERT INTO user_db.t_user (id, balance) VALUES (1, 1000);