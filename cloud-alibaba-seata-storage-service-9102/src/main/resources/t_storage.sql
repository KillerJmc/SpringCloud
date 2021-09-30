create table t_storage
(
    id      int auto_increment
        primary key,
    residue int null
);

INSERT INTO storage_db.t_storage (id, residue) VALUES (1, 100);