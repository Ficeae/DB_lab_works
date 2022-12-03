CREATE DATABASE IF NOT EXISTS zolochevskyi_p;
USE zolochevskyi_p;


DROP TABLE IF EXISTS delivery_products;
DROP TABLE IF EXISTS delivery;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS shop;


CREATE TABLE shop (
	id INT AUTO_INCREMENT PRIMARY KEY,
	country VARCHAR(60) NOT NULL,
	city VARCHAR(85) NOT NULL,
	adress VARCHAR(40) NOT NULL
) ENGINE = INNODB;

CREATE INDEX shop_adress ON shop (adress);

INSERT INTO shop (country, city, adress) VALUES
	('Ukraine', 'Ternopil', 'Vilna, 8'),
    ('Ukraine', 'Kiyv', 'Rebelpathova, 11'),
    ('Ukraine', 'Lviv', 'Chornovola, 1');

CREATE TABLE product (
	id INT AUTO_INCREMENT PRIMARY KEY,
    shop_id INT,
	manufacturer VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	category VARCHAR(50),
	price DECIMAL(6,2),
	arrived DATETIME NOT NULL,
	expired DATE,
	is_available TINYINT NOT NULL
) ENGINE = INNODB;
ALTER TABLE product
	ADD FOREIGN KEY (shop_id)
    REFERENCES shop (id);

CREATE INDEX product_name ON product (name);

INSERT INTO product (shop_id, manufacturer, name, category, price, arrived, expired, is_available) VALUES
	(1, 'Polyana', 'Pasta Vishukana 400g', 'flour', 40.00, '2022-10-10', NULL, 1),
    (1, 'Halichyna', 'Yoghurt Palyanitsa 180g', 'milk', 23.50, '2022-10-10', NULL, 1),
	(1, 'Veres', 'Perec chilly 250g', 'canned', 60.00, '2022-10-10', NULL, 1),
	(1, 'Nestle', 'Nesquick 200g', 'breakfast', 45.75, '2022-10-10', NULL, 1),
	(1, 'RIP&TEAR', 'DEMONS MEAT', 'MEAT.', 666.13, '2022-10-10', NULL, 0);

CREATE TABLE customer (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(40) NOT NULL,
	surname VARCHAR(40) NOT NULL,
    phone VARCHAR(20),
	adress VARCHAR(40) NOT NULL
) ENGINE = INNODB;

CREATE INDEX customer_adress ON customer (adress);

INSERT INTO customer (name, surname, phone, adress) VALUES
	('Ihor', 'Vuyko', '096*****13', 'Stefanenka, 3'),
	('Stepan', 'Lis', '067*****01', 'Dorijna, 6'),
	('John', 'Silver', '044*****56', 'Polishkova, 16'),
	('Valeria', 'Shypit', '068*****98', 'Nichnogo Dozoru, 9'),
	('Judy', 'Jecksons', '044*****44', 'EEEEE, E');

CREATE TABLE delivery (
id INT AUTO_INCREMENT PRIMARY KEY,
customer_id INT NOT NULL,
ordered_time DATETIME NOT NULL,
arrival TIME NOT NULL,
urgency_price DECIMAL(5,2)
) ENGINE = INNODB;
ALTER TABLE delivery
	ADD FOREIGN KEY (customer_id)
    REFERENCES customer (id);

INSERT INTO delivery (customer_id, ordered_time, arrival, urgency_price) VALUES
	(1, '2022-11-10 13:44:52', '15:00:00', NULL),
	(2, '2022-11-10 13:53:06', '15:05:00', NULL),
	(3, '2022-11-10 14:04:18', '15:07:00', NULL),
	(4, '2022-11-10 14:31:40', '16:00:00', NULL),
	(5, '2022-11-10 14:36:08', '15:00:00', 120.00);

CREATE TABLE delivery_products (
product_id INT NOT NULL,
delivery_id INT NOT NULL,
quantity INT,
weight DECIMAL(5,3) NOT NULL,
price DECIMAL(5,2) NOT NULL,
PRIMARY KEY (product_id, delivery_id)
) ENGINE = INNODB;
ALTER TABLE delivery_products
	ADD FOREIGN KEY (product_id)
    REFERENCES product (id),
    ADD FOREIGN KEY (delivery_id)
    REFERENCES delivery (id);

INSERT INTO delivery_products (product_id, delivery_id, quantity, weight, price) VALUES
	('4', '1', '1', '0.200', '45.75'),
    ('3', '2', '2', '0.500', '120.00'),
    ('1', '3', '1', '0.400', '40.00'),
    ('2', '4', '4', '0.720', '94.00');
