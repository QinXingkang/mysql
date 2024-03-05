#演示字符串相关函数的使用
-- CHARSET(Str) 返回字串字符集
SELECT CHARSET(`user_name`) FROM employee;
-- CONCAT(string2 [])连接字串,将多个列拼接成一列
SELECT CONCAT(user_name,'job is ', job) FROM employee;

SELECT * FROM employee;

-- dual 亚元表，系统表 可以作为测试表来使用
SELECT INSTR('韩顺平','平') FROM DUAL;

SELECT UCASE(user_name) FROM employee;

SELECT LCASE(user_name) FROM employee;

SELECT RIGHT(user_name,2) FROM employee

-- 按字节返回
SELECT LENGTH(user_name) FROM employee;

SELECT * FROM employee;

SELECT REPLACE(job,'巡山','巡山员') FROM employee;

SELECT * FROM employee;

SELECT STRCMP('韩顺平','Hsp') FROM DUAL;

SELECT LTRIM('  韩顺平') FROM DUAL;

SELECT TRIM('   hsp    ') FROM DUAL;

-- 1
SELECT CONCAT(UCASE(SUBSTRING(user_name,1,1)) ,SUBSTRING(user_name,2)) AS new_name
	FROM employee;


SELECT CONCAT(UCASE(LEFT(user_name,1)),LCASE(SUBSTRING(user_name,2))) AS new_name
	FROM employee;

 