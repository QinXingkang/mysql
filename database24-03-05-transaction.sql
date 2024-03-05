-- 事务的几个重要的概念和具体操作
-- 1.创建一张测试表
CREATE TABLE t29
	(id INT,
	`name` VARCHAR(32));

-- 2.开始事务
START TRANSACTION

-- 3.设置保存点
SAVEPOINT a
-- 执行dml操作
INSERT INTO t29 VALUES(100,'tom');
SELECT * FROM t29;

SAVEPOINT b
INSERT INTO t29 VALUES(200,'jack');
SELECT * FROM t29;

-- 回退到b
ROLLBACK TO b
SELECT * FROM t29

-- 回退到a
ROLLBACK TO a
SELECT * FROM t29

-- 表示直接回退到事务开始的状态
ROLLBACK

-- 如果执行commit，就无法再回退到commit之前的事务
COMMIT

-- transaction_detail

-- 1.如果不开始事务，默认情况下，dml操作是自动提交的，不能回滚
INSERT INTO t29 VALUES(300,'milan');
SELECT * FROM t29
-- 2.如果开始一个事务，没有创建保存点，可以执行rollback，默认就是回退到事务开始的状态
START TRANSACTION
INSERT INTO t29 VALUES(400,'king');
INSERT INTO t29 VALUES(500,'scott');
SELECT * FROM t29
ROLLBACK
COMMIT
-- 3.可以在事务中（没有提交）创建多个保存点
-- 	savepoint aaa；

-- 4.可以在事务提交之前选择回退到哪个保存点

-- 5.mysql事务机制需要innodb的存储引擎才可以使用，MyISAM不支持
-- 6.开始一个事务 start transaction， set autocommit = off;
START TRANSACTION
SET autocommit = off

-- 演示mysql的事务隔离级别
-- 查看当前mysql的隔离级别
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ
SELECT @@tx_isolation; -- REPEATABLE-READ

-- 设置隔离级别 read uncommitted
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
SELECT @@tx_isolation; -- READ-UNCOMMITTED

CREATE TABLE `account`(
	id INT,
	`name` VARCHAR(32), 
	money INT);

-- 查看当前会话隔离级别
SELECT @@tx_isolation;
-- 查看系统当前隔离级别
SELECT @@global.tx_isolation;
-- 设置当前会话隔离级别
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
-- 设置系统当前隔离级别
SET GLOBAL TRANSACTION ISOLATION LEVEL READ UNCOMMITTED