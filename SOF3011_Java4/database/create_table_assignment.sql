CREATE DATABASE sof3011_java4_assignment;

USE sof3011_java4_assignment;

CREATE TABLE categories (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE movies (
	id BIGINT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255),
	description MEDIUMTEXT,
	director VARCHAR(255),
	actors VARCHAR(255),
	producer VARCHAR(255),
	country VARCHAR(255),
	runtime INT,
	releaseYear INT,
	viewCount INT,
	likeCount INT,
	trailer VARCHAR(255),
	banner VARCHAR(255),
	poster VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE categories_movies (
	categoryid BIGINT NOT NULL,
	movieid BIGINT NOT NULL,
	PRIMARY KEY(movieid,categoryid),
	FOREIGN KEY (categoryid) REFERENCES categories(id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (movieid) REFERENCES movies(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE episodes (
	id BIGINT NOT NULL AUTO_INCREMENT,
	number INT,
	movieid BIGINT,
	link VARCHAR(255),
	PRIMARY KEY(id),
	FOREIGN KEY (movieid) REFERENCES movies(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE users (
	id BIGINT NOT NULL AUTO_INCREMENT,
	username VARCHAR(255),
	password VARCHAR(255),
	fullname VARCHAR(255),
	email VARCHAR(255),
	role BIT,
	status BIT,
	verify VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE favorites (
	userid BIGINT NOT NULL,
	movieid BIGINT NOT NULL,
	PRIMARY KEY(userid,movieid),
	FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (movieid) REFERENCES movies(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE themes (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE movies_themes (
	movieid BIGINT NOT NULL,
	themeid BIGINT NOT NULL,
	PRIMARY KEY(movieid,themeid),
	FOREIGN KEY (movieid) REFERENCES movies(id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (themeid) REFERENCES themes(id) ON DELETE CASCADE ON UPDATE CASCADE
);