DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         name VARCHAR(250),
                         email VARCHAR(250),
                         uuid VARCHAR(250)
);