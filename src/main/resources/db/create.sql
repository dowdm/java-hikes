SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS hikes (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    length INTEGER,
    elevationGain INTEGER,
    state VARCHAR,
    imageUrl VARCHAR

);

CREATE TABLE IF NOT EXISTS comments (
    id int PRIMARY KEY auto_increment,
    userId INTEGER,
    content VARCHAR,
    hikeId INTEGER
);

CREATE TABLE IF NOT EXISTS users (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
--    completedHikes VARCHAR
);