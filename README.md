# WallTrackerAPI

## Ausführung
Die API kann getestet werden, indem der Code gepullt und ausgeführt wird.
Die Vorraussetzungen sind ein Docker, der eine MySQL Datenbank hostet und eine Datenbank, welche passend zur API aufgebaut ist. Für den zweiten Punkt, kann innerhalb von Intellij in der MySQL Konsole dieser Code ausgeführt werden:


CREATE DATABASE walltracker;

USE walltracker;

CREATE TABLE address (id INTEGER AUTO_INCREMENT, street VARCHAR(20), city VARCHAR(20), postalcode INTEGER, country VARCHAR(20), primary key (id));

CREATE TABLE opening_hours (id INTEGER AUTO_INCREMENT, monday VARCHAR(20), tuesday VARCHAR(20), wednesday VARCHAR(20), thursday VARCHAR(20), friday VARCHAR(20), saturday VARCHAR(20), sunday VARCHAR(20), primary key (id));


CREATE TABLE location (id INTEGER AUTO_INCREMENT, location_name VARCHAR(20), opening_hours_id INTEGER, address_id INTEGER, ratings_mean FLOAT, FOREIGN KEY(opening_hours_id) REFERENCES opening_hours(id), FOREIGN KEY(address_id) REFERENCES address(id), primary key (id));

CREATE TABLE route_setter (id INTEGER AUTO_INCREMENT, location_id INTEGER, first_name VARCHAR(20), last_name VARCHAR(20), date_of_birth DATE, ratings_mean FLOAT,  FOREIGN KEY(location_id) REFERENCES location(id),primary key (id));


CREATE TABLE boulder (id INTEGER AUTO_INCREMENT, location_id INTEGER, difficulty INTEGER, route_setter_id INTEGER, ratings_mean FLOAT, FOREIGN KEY(location_id) REFERENCES location(id), FOREIGN KEY(route_setter_id) REFERENCES route_setter(id), primary key (id));

CREATE TABLE user (id INTEGER AUTO_INCREMENT, first_name VARCHAR(20), last_name VARCHAR(20), date_of_birth DATE, address_id INTEGER, FOREIGN KEY(address_id) REFERENCES address(id), primary key (id));


CREATE TABLE ratings (user_id INTEGER, boulder_id INTEGER, location_id INTEGER, rating INTEGER, review VARCHAR(1000), date DATE, FOREIGN KEY(user_id) REFERENCES user(id), FOREIGN KEY(boulder_id) REFERENCES boulder(id), FOREIGN KEY(location_id) REFERENCES location(id), primary key (user_id, boulder_id, location_id));


Mittels des Postman Clients können nun bestimmte Anfragen gestellt werden.
