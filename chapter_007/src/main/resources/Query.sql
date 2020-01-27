create table type (
    id serial primary key,
    name varchar(20)
);

Insert into type (name) values
    ('Сыр'),
    ('Молоко');

create table product (
	id serial primary key,
	name varchar(20),
	type_id int references type(id),
	expired_date timestamp,
	price double precision
);

insert into product (name, type_id, expired_date, price) VALUES
    ('Костромской', 1, '2020-02-28 09:08:01', 300.5),
	('Российский', 1, '2020-02-29 09:08:01', 298.4),
	('Голландский', 1, '2020-02-20 09:08:01', 350.1),
	('Ленское 2.5%', 2, '2020-02-04 09:08:01', 44.3),
	('Домашнее 3.2%', 2, '2020-02-05 09:08:01', 50.2),
	('Parmalat 1.0%', 2, '2020-03-30 09:08:01', 82.5);

--1. Написать запрос получение всех продуктов с типом "Сыр"
SELECT * FROM product as p WHERE p.type_id = 1;

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT p.name FROM product as p WHERE p.name LIKE '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM product as p WHERE p.expired_date BETWEEN '2020-02-01' and '2020-02-29';

--4. Написать запрос, который выводит самый дорогой продукт.
SELECT * FROM product as p WHERE p.price = (SELECT max(p.price) FROM product as p);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT t.name, count(p.name) FROM product as p INNER JOIN type as t ON t.id = p.type_id GROUP BY t.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT p.name FROM product as p INNER JOIN type as t on p.type_id = t.id WHERE t.name = 'СЫР' and t.name = 'МОЛОКО';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT t.name FROM product as p INNER JOIN type AS t on p.type_id = t.id GROUP BY t.name HAVING COUNT(t.id)<10;

--8. Вывести все продукты и их тип.
SELECT t.name, p.name FROM product as p INNER JOIN type AS t on p.type_id = t.id;
