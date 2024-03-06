-- 视图的使用

-- 创建视图
CREATE VIEW emp_view01
	AS SELECT id, user_name, job,`resume` FROM employee;
SELECT * FROM emp_view01
DESC emp_view01

SELECT id,job FROM emp_view01

SHOW CREATE VIEW emp_view01

DROP VIEW emp_view01

UPDATE emp_view01
	SET job = '清洁员'
	WHERE id = 100;
	
CREATE VIEW emp_view02
	AS SELECT id, `user_name` FROM emp_view01
SELECT * FROM emp_view02

-- 视图的课堂练习

SELECT empno, ename, dname, grade
	FROM emp, dept, salgrade
	WHERE emp.deptno = dept.deptno AND 
	(sal BETWEEN losal AND hisal)
	
CREATE VIEW emp_view03 AS
	SELECT empno, ename, dname, grade
	FROM emp, dept, salgrade
	WHERE emp.deptno = dept.deptno AND 
	(sal BETWEEN losal AND hisal)
	
DESC emp_view03
SELECT * FROM emp_view03

