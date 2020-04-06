-- Create a new database if not exists
CREATE DATABASE IF NOT EXISTS PYTHON_MYSQL_DEMO;

-- Use the database just created
USE PYTHON_MYSQL_DEMO;

DROP TABLE IF EXISTS EMPLOYEE_ENCRYPTED;

-- Create Employee Table if not exists
-- The below style has an issue on the AUTO_INCREMENT keys. Prefer the other style of create table like syntax instead.

/*CREATE TABLE IF NOT EXISTS EMPLOYEE_ENCRYPTED 
AS
	SELECT 
		*
	FROM
		EMPLOYEE;
*/

CREATE TABLE IF NOT EXISTS EMPLOYEE_ENCRYPTED LIKE EMPLOYEE;

-- If needed, uncomment this to have the initial values from the EMPLOYEE table to the EMPLOYEE_ENCRYPTED table
-- INSERT INTO EMPLOYEE_ENCRYPTED (ID, EMP_NAME, USER_ID, PASSWORD) SELECT ID, EMP_NAME, USER_ID, PASSWORD FROM EMPLOYEE;

-- retrieve the sample values
SELECT * FROM EMPLOYEE_ENCRYPTED;
