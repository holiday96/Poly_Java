CREATE DATABASE sof3011_java4_assignment;

CREATE TABLE categories (
    id BIGINT NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE movies (
	id BIGINT NOT NULL,
	title VARCHAR(255),
	description MEDIUMTEXT,
	director VARCHAR(255),
	actors VARCHAR(255),
	producer VARCHAR(255),
	country VARCHAR(255),
	runtime INT,
	`release` INT,
	view INT,
	`like` INT,
	trailer VARCHAR(255),
	banner VARCHAR(255),
	poster VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE categories_movies (
	categoryid BIGINT NOT NULL,
	movieid BIGINT NOT NULL,
	PRIMARY KEY(movieid,categoryid),
	FOREIGN KEY (categoryid) REFERENCES categories(id),
	FOREIGN KEY (movieid) REFERENCES movies(id)
);

CREATE TABLE episodes (
	number INT NOT NULL,
	movieid BIGINT NOT NULL,
	link VARCHAR(255),
	PRIMARY KEY(number,movieid),
	FOREIGN KEY (movieid) REFERENCES movies(id)
);

CREATE TABLE users (
	id BIGINT NOT NULL,
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
	FOREIGN KEY (userid) REFERENCES users(id),
	FOREIGN KEY (movieid) REFERENCES movies(id)
);

CREATE TABLE themes (
	id BIGINT NOT NULL,
	name VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE movies_themes (
	movieid BIGINT NOT NULL,
	themeid BIGINT NOT NULL,
	PRIMARY KEY(movieid,themeid),
	FOREIGN KEY (movieid) REFERENCES movies(id),
	FOREIGN KEY (themeid) REFERENCES themes(id)
);