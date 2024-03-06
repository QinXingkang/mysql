-- mysql用户的管理
-- 原因：当我们做项目开发时，可以根据不同的开发人员，赋给他相应的mysql操作权限
-- 所以，mysql数据库管理人员(root),根据需要创建不同的用户，赋给相应的权限，供人员使用

-- 1.创建新的用户
-- 'qxk'@'localhost'表示用户的完整信息 'qxk'用户名 'localhost' 登录的ip
-- 'qxk'密码 ， 但是注意 存放到mysql.user表时，是加密后的密码
CREATE USER 'qxk'@'localhost' IDENTIFIED BY 'qxk'

SELECT `host` , `user`, authentication_string 
	FROM mysql.`user`

-- 2.删除用户
DROP USER 'qxk'@'localhost'

-- 3.登录

-- 修改自己的密码
SET PASSWORD = PASSWORD('qxk');

-- 修改其他人的密码
SET PASSWORD FOR 'qxk'@'localhost' = PASSWORD('qxk');

CREATE USER 'shunping'@'localhost' IDENTIFIED BY '123'

CREATE DATABASE testdb
CREATE TABLE news(
	id INT,
	content VARCHAR(32));
-- 添加一条测试数据
INSERT INTO news VALUES(100,'北京新闻');

-- 给shunping用户分配查看news表 和添加 news的权限
GRANT SELECT, INSERT
	ON testdb.`news`
	TO 'shunping'@'localhost'

SELECT * FROM news

-- 可以增加权限
GRANT UPDATE
	ON testdb.`news`
	TO 'shunping'@'localhost'
	
-- 修改顺平的密码
SET PASSWORD FOR 'shunping'@'localhost' = PASSWORD('123')

-- 回收顺平在testdb.news的所有权限
REVOKE SELECT, UPDATE, INSERT ON testdb.`news` FROM 'shunping'@'localhost'

DROP USER 'shunping'@'localhost'

SELECT * FROM mysql.`user`