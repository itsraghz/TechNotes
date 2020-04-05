-- Create a new database if not exists
CREATE DATABASE IF NOT EXISTS PYTHON_MYSQL_DEMO;

-- Use the database just created
USE PYTHON_MYSQL_DEMO;

-- Create Employee Table if not exists
CREATE TABLE IF NOT EXISTS EMPLOYEE_ENCRYPTED 
AS
	SELECT 
		*
	FROM
		EMPLOYEE;

-- retrieve the sample values
SELECT * FROM EMPLOYEE_ENCRYPTED;
