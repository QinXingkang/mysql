CREATE TABLE student(
	id INT NOT NULL DEFAULT 1,
	NAME VARCHAR(20) NOT NULL DEFAULT '',
	chinese FLOAT NOT NULL DEFAULT 0.0,
	english FLOAT NOT NULL DEFAULT 0.0,
	math FLOAT NOT NULL DEFAULT 0.0);
	
INSERT INTO student(id,`name`,chinese,english,math) VALUES(1,'韩顺平',89,78,90);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(2,'张飞',69,98,56);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(3,'宋江',87,78,77);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(4,'关羽',88,98,90);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(5,'赵云',82,84,67);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(6,'欧阳锋',55,85,45);
INSERT INTO student(id,`name`,chinese,english,math) VALUES(7,'黄蓉',75,65,30);

SELECT * FROM student

SELECT `name`,english FROM student;

SELECT DISTINCT * FROM student;

-- 统计每个学生的总分
SELECT `name`,(chinese + english + math) FROM student;
-- 在所有学生总分加10分的情况
 SELECT `name`,(chinese + english + math + 10) FROM student;
-- 使用别名表示学生分数
SELECT `name`,(chinese + english + math) AS total_score FROM student;

SELECT * FROM student WHERE `name` = '赵云';

SELECT * FROM student WHERE (english > 90);

SELECT * FROM student WHERE (chinese + english + math > 200);

SELECT * FROM student WHERE math > 60 AND english > 90;

SELECT * FROM student WHERE english > chinese;

SELECT * FROM student WHERE (chinese + english + math > 200)  AND `name` LIKE '韩%';

SELECT * FROM student WHERE english > 80 AND english < 90;

SELECT * FROM student WHERE math = 89 OR math = 90 OR math = 91;

SELECT * FROM student WHERE math IN (89,90,91);

SELECT * FROM student WHERE `name` LIKE '韩%';

SELECT * FROM student WHERE chinese BETWEEN 70 AND 80

SELECT * FROM student WHERE (chinese + english + math) IN (189,190,191);

SELECT * FROM student WHERE `name` LIKE '韩%' OR '宋%';

SELECT * FROM student ORDER BY math ASC;

SELECT `name`,(chinese + english + math) AS total_scorc FROM student ORDER BY total_scorc DESC;

-- 统计函数的使用
SELECT COUNT(*) FROM student

SELECT COUNT(*) FROM student WHERE math > 90

SELECT COUNT(*) FROM student WHERE (chinese + english + math > 200)

SELECT SUM(math) FROM student

SELECT SUM(math),SUM(chinese),SUM(english) FROM student;

SELECT SUM(math + english + chinese) FROM student;

SELECT SUM(math)/7 FROM student

 