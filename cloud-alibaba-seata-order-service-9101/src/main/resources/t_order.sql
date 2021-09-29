create database if not exists order_db;
use order_db;

create table t_order
(
    id         int auto_increment
        primary key,
    user_id    int    null,
    product_id int    null,
    amount     int    null,
    money      double null
);