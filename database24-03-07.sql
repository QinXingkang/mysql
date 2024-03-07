-- 2
DESC employee

-- 3
SELECT id, user_name
	FROM employee

SELECT id,Salary*12 AS year_sal
	FROM employee
	
-- 4.1
SELECT id,user_name,Salary
	FROM employee
	WHERE Salary > 2000
	
-- 4.2
SELECT id,user_name,Salary
	FROM employee
	WHERE Salary > 3000 OR Salary < 5000
	
-- 4.3
SELECT * FROM student
SELECT * FROM employee
SELECT id,user_name,job
	FROM employee

SELECT user_name,Salary
	FROM employee
	WHERE id = 300 OR id = 400
	
SELECT id, user_name, Salary
	FROM employee
	WHERE Salary IS NOT NULL
	ORDER BY id DESC
	
SELECT ename, (sal + IFNULL(comm,0)) * 13 AS '年收入'
	FROM emp;
	
SELECT * FROM employee
	WHERE user_name NOT LIKE '%R%'
	
SELECT LEFT(user_name,3) FROM employee

SELECT REPLACE(user_name,'A','a')
	FROM employee
	
