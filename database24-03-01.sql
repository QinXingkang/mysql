-- 演示update语句
-- 1.如果没有带where条件，会修改所有的Salary记录
UPDATE employee SET Salary = 5000;
UPDATE employee SET Salary = 3000
		WHERE user_name = '小妖怪';
UPDATE employee SET Salary = Salary + 1000
		WHERE user_name = '老妖怪';
INSERT INTO employee VALUES(200,'老妖怪','1990-11-11','2000-11-11 10:10:10','监督员',3000,'应聘','c');

UPDATE employee SET Salary = Salary + 1000 , job = '经理'
		WHERE user_name = '老妖怪'
UPDATE employee SET id = 400
		WHERE user_name = 'lxd'
		
DELETE FROM employee WHERE user_name = '老妖怪'

DELETE * FROM employee

SELECT * FROM employee