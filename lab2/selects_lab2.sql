USE labor_sql;

SELECT ship, battle, result
FROM outcomes
WHERE result = 'sunk';

SELECT name, class
FROM ships
WHERE class REGEXP '[^g]o$';

SELECT DISTINCT M1.model model1, M2.model model2, M1.speed, M1.ram
FROM pc M1, pc M2
WHERE M1.speed = M2.speed 
	AND M1.ram = M2.ram 
	AND M1.model >= M2.model 
    AND M1.code <> m2.code;

SELECT country, class
FROM classes
WHERE country = 'Ukraine' OR country = ANY(SELECT country FROM classes);

SELECT DISTINCT maker
FROM product
WHERE type = 'Laptop' AND maker IN (SELECT maker FROM product WHERE type = 'Printer');

SELECT CONCAT('From ', town_from, ' to ', town_to) AS route
FROM trip;

SELECT country, 
	(SELECT COUNT(name) FROM ships
    WHERE class = classes.class) AS numShips,
    (SELECT MIN(launched) FROM ships
    WHERE class = classes.class) AS year
FROM classes
GROUP BY country
HAVING MAX(numShips) AND MIN(year);

SELECT DISTINCT maker,
	(SELECT AVG(screen) FROM laptop
    WHERE model = product.model) AS avgScreen
FROM product
WHERE type = 'Laptop'
GROUP BY maker;

SELECT outcome.point,
	CASE
		WHEN outcome.date = ANY(SELECT date FROM outcome GROUP BY date HAVING COUNT(date) > 1) THEN 'more than once a day'
        WHEN outcome.date != ANY(SELECT date FROM outcome GROUP BY date HAVING COUNT(date) > 1) THEN 'once a day'
        ELSE 'both'
	END AS res
FROM outcome LEFT JOIN outcome_o ON outcome.date = outcome_o.date;

SELECT name
FROM ships
WHERE name RLIKE ' '
UNION
SELECT ship
FROM outcomes
WHERE ship RLIKE ' ';