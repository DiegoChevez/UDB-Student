CREATE DATABASE myapp CHARACTER SET utf8 COLLATE utf8_general_ci;
USE myapp;

CREATE TABLE user(
	id int NOT NULL auto_increment PRIMARY KEY,
	fullname varchar(500) NOT NULL,
	username varchar(100) NOT NULL UNIQUE,
	email varchar(255) NOT NULL UNIQUE,
	password varchar(255) NOT NULL,
	created_at datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;