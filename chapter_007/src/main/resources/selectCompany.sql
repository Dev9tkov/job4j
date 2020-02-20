CREATE TABLE company (
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person (
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id, name)  values
    (1, 'Twitter'),
    (2, 'Coca-Cola'),
    (3, 'Apple'),
    (4, 'Visa'),
    (5, 'Netflix');

insert into person (id, name, company_id)  values
    (1, 'Nancy Davolio', 1),
    (2, 'Andrew Fuller', 1),
    (3, 'Janet Levering', 2),
    (4, 'Steven Buchanan', 2),
    (5, 'Rober King', 3),
    (6, 'Laura Callahan', 3),
    (7, 'Anne Dobsworth', 4),
    (8, 'Charlotte Cooper', 4),
    (9, 'Yoshi Nagase', 5),
    (10, 'Mayumi Ohno', 5),
    (11, 'Enriko Mafather', 5);


-- 1) Retrieve in a single query:
-- - names of all persons that are NOT in the company with id = 5
-- - company name for each person
SELECT p.name, c.name
FROM person AS p INNER JOIN company AS c
ON c.id = p.company_id
WHERE NOT (company_id=5);

-- 2) Select the name of the company with the maximum number of persons + number of persons in this company
SELECT c.name, COUNT(p.id)
FROM person AS p INNER JOIN company AS c
ON c.id = p.company_id
GROUP BY c.name
ORDER BY count(p.id) DESC LIMIT 1;
