--1. Есть таблица встреч(id, name), есть таблица юзеров(id, name)

create table meeting (
    id serial primary key,
    name varchar(200)
);

create table users (
    id serial primary key,
    name varchar(200),
);

create table users_to_meeting (
    id serial primary key,
    meeting_id int references meeting(id),
    users_id int references users(id),
    users_agrement boolean
);

insert into meeting (name) values
    ('международные'),
    ('отраслевые'),
    ('региональные'),
    ('внутренние');

insert into users (name) values
    ('Noel'),
    ('Jhon'),
    ('Iohan'),
    ('Dirk');

insert into users_to_meeting (meeting_id, users_id, users_agrement) values
    (1, 1, true),
    (2, 1, false),
    (3, 2, true),
    (4, 2, false),
    (4, 3, true),
    (3, 3, true),
    (2, 4, false),
    (1, 4, true),
    (1, 3, false);


--2. Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.

select m.name, count (users_id) from meeting as m
inner join users_to_meeting as c
ON m.id = c.meeting_id
where users_agrement = true
group by m.name;

--3. Нужно получить все совещания, где не было ни одной заявки на посещения
--Догадался сделать только таким образом:
--Первая выборка выводит таблицу имя совещание - кол-во тех, кто не идет на совещание
--Вторая выборка выводит таблицу имя совещания - кол-во записавшихся
--Таким образом пересечение этих 2ух таблиц дает нам совещания где не было ни одной заявки.
select m.name, count (users_id) from meeting as m
inner join users_to_meeting as c
ON m.id = c.meeting_id
where users_agrement = false
group by m.name
INTERSECT
select m.name, count (users_id) from meeting as m
inner join users_to_meeting as c
ON m.id = c.meeting_id
group by m.name;










