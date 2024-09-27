CREATE DATABASE IF NOT EXISTS hellotiersdb; 

USE hellotiersdb; 

CREATE TABLE IF NOT EXISTS User (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    firstName VARCHAR(20), 
    lastName VARCHAR(20), 
    userName VARCHAR(20), 
    dni VARCHAR(9), 
    email VARCHAR(20), 
    birthDate DATE, 
    password VARCHAR(20)
); 

INSERT INTO User (firstName, lastName, userName, dni, email, birthDate, password) 
    VALUES (
        'Jane', 'Doe', 'userFromDB', '12345678X', 'jane.doe@gmail.com', '1999-09-05', 'abcd*1234'
    );

    -- script para la shell
-- CREATE DATABASE IF NOT EXISTS hellotiersdb; 
-- USE hellotiersdb; 
-- CREATE TABLE User (id INT AUTO_INCREMENT PRIMARY KEY, firstName VARCHAR(20), lastName VARCHAR(20), userName VARCHAR(20), dni VARCHAR(9), email VARCHAR(20), birthDate DATE, password VARCHAR(20)); 
-- INSERT INTO User (firstName, lastName, userName, dni, email, birthDate, password) VALUES ('Jane', 'Doe', 'userFromDB', '12345678X', 'jane.doe@gmail.com', '1999-09-05', 'abcd*1234');
