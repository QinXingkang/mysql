`news`-- 创建测试表 演员表

CREATE TABLE actor(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	sex CHAR(1) NOT NULL DEFAULT '女',
	brondate DATETIME,
	phone VARCHAR(12));
	
SELECT * FROM actor

-- 增加两条记录用于测试
INSERT INTO actor 
	VALUES(NULL,'hsp','男','1972-11-11','120');
	
-- 演示sql注入
-- 创建表
CREATE TABLE admin(-- 管理员表
	`name` VARCHAR(32) NOT NULL UNIQUE,
	pwd VARCHAR(32) NOT NULL DEFAULT '') CHARACTER SET utf8;
	
INSERT INTO admin VALUES('tom','123')

-- 查询某个管理员是否存在
SELECT * FROM admin 
	WHERE `name` = 'tom'
	
-- SQL
-- 输入用户名为1' or 
-- 输入密码为 or '1' = '1

SELECT * FROM admin 
	WHERE `name` = '1' OR  'and pwd = ' OR '1' = '1'
	
SELECT * FROM admin

CREATE TABLE `account`(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	balance DOUBLE NOT NULL DEFAULT 0) CHARACTER SET utf8;
	
INSERT INTO account VALUES(NULL,'马云',3000);
INSERT INTO account VALUES(NULL,'马化腾',10000);

SELECT * FROM account

CREATE TABLE admin2(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(32) NOT NULL,
	`password` VARCHAR(32) NOT NULL);

SELECT COUNT(*) FROM admin2
DROP TABLE admin2