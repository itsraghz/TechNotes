-- Drop database if exists
DROP DATABASE IF EXISTS PYTHON_MYSQL_DEMO;

-- Create a new database if not exists
CREATE DATABASE IF NOT EXISTS PYTHON_MYSQL_DEMO;

-- Use the database just created
USE PYTHON_MYSQL_DEMO;

-- Create Employee Table if not exists
CREATE TABLE IF NOT EXISTS EMPLOYEE
(
	Id INTEGER AUTO_INCREMENT PRIMARY KEY,
	EMP_NAME VARCHAR(50) NOT NULL,
	USER_ID VARCHAR(50) NOT NULL,
	PASSWORD VARCHAR(250) NOT NULL COMMENT 'a long text having the scrambled encrypted version of the data'
);

-- insert sample data
INSERT INTO EMPLOYEE (EMP_NAME, USER_ID, PASSWORD) VALUES ('Karthiga Karpagam R', 'karthiga', 'ItsMeKKR$');
INSERT INTO EMPLOYEE (EMP_NAME, USER_ID, PASSWORD) VALUES ('Karthick Muthu R', 'karthick', 'ItsMeKMR#');

-- retrieve the sample values
SELECT * FROM EMPLOYEE;
