DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         name VARCHAR(250),
                         email VARCHAR(250),
                         uuid VARCHAR(250)
);

DROP TABLE IF EXISTS positions;

CREATE TABLE positions (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         name VARCHAR(250),
                         location VARCHAR(250),
                         url VARCHAR(250)
);