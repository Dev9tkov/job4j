create table car_body (
    id serial primary key,
    name varchar(20)
);

insert into car_body (name) values
    ('Грузовая'),
    ('Седан'),
    ('Хэтчбек'),
    ('Универсал');

create table engine (
    id serial primary key,
    name varchar(20)
);

insert into engine (name) values
    ('Бензиновый'),
    ('Дизельный'),
    ('Газовый');

create table transmission (
    id serial primary key,
    name varchar(20)
);

insert into transmission (name) values
    ('Механическая'),
    ('Робот'),
    ('Автомат'),
    ('Вариатор');

create table car_storage (
    id serial primary key,
    name varchar(20),
    car_body_id int references car_body(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id),
);

insert into garage (name, car_body_id, engine_id, transmission_id) values
    ('Газель', 1, 2, 1),
    ('Лада Веста', 2, 2, 3),
    ('Toyota Yaris', 3, 3, 4),
    ('Wollksvagen Polo', 2, 3, 2),
    ('Лада Гранта', 4, 2, 1),
    ('Shkoda Oktavia', 4, 1, 2);

--1. Вывести список всех машин и все привязанные к ним детали.
SELECT *
FROM garage AS g
INNER JOIN car_body AS c ON c.id = g.car_body_id
INNER JOIN engine AS e ON e.id = g.engine_id
INNER JOIN transmission AS t ON t.id = g.transmission_id

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
--не использованные кузова
SELECT *
FROM car_body AS c
LEFT JOIN garage AS g ON c.id = g.car_body_id
WHERE c.id IS null

--не использованные типы двигателя
SELECT *
FROM engine AS e
LEFT JOIN garage AS g ON e.id = g.engine_id
WHERE e.id IS null

--не использованные коробки передач
SELECT *
FROM transmission AS t
LEFT JOIN garage AS g ON t.id = g.transmission
WHERE t.id IS null




