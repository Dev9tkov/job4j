--create Database
create database tracker;

--connect
\c tracker;

--create tables
--Пользователи
create table users (
    Id serial primary key,
    Name character varying(20),
    requests_id int references requests(Id)
);
--Роли
create table roles (
    Id serial primary key,
    Name character varying(20),
    users_id int references users(Id)
);
--Права ролей
create table rights (
Id serial primary key,
Name character varying(20)
);
--Заявки
create table requests (
    Id serial primary key,
    Name character varying(20),
    comments_id int references comments(Id),
    files_id int references files(Id)
);
--Комментарии заявок
create table comments (
    Id serial primary key,
    Name character varying(20)
);
--Приложенные файлы
create table files (
    Id serial primary key,
    Name character varying(20)
);
--Состояние заявки
create table state (
    Id serial primary key,
    State boolean,
    requests_id int references requests(Id)
);
--Категория заявки
create table category (
    Id serial primary key,
    Name character varying(20),
    requests_id int references requests(Id)
);

--create many to many table
create table roles_rights(
    Id serial primary key,
    roles_id int references roles(Id),
    rights_id int references rights(Id)
);





