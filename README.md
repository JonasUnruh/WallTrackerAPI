# WallTrackerAPI

## Ausführung
Die API kann getestet werden, indem der Code gepullt und ausgeführt wird.
Die Varraussetzungen sind ein Docker, der eine MySQL Datenbank hostet und eine Datenbank, welche passend zur API aufgebaut ist. Für den zweiten Punkt, kann innerhalb von Intellij in der MySQL Konsole dieser Code ausgeführt werden:


CREATE DATABASE walltracker;

USE walltracker;

CREATE TABLE boulder (id INTEGER AUTO_INCREMENT, difficulty INTEGER, primary key (id));

CREATE TABLE user (id INTEGER AUTO_INCREMENT, first_name VARCHAR(20), last_name VARCHAR(20), age INTEGER, owner BOOLEAN,
primary key (id));

CREATE TABLE ratings (id INTEGER AUTO_INCREMENT, user_id INTEGER, boulder_id INTEGER, rating INTEGER, date DATE,
FOREIGN KEY(user_id) REFERENCES user(id), FOREIGN KEY(boulder_id) REFERENCES boulder(id), primary key (id));


Mittels des Postman Clients können nun bestimmte Anfragen gestellt werden.
