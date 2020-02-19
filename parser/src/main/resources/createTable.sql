--Создание БД
DROP TABLE IF EXISTS vacancy;
CREATE TABLE vacancy (vacancy_id serial PRIMARY KEY, name varchar(200), description text, link varchar(200));