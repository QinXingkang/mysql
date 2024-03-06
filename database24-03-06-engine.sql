-- 表类型和存储引擎

-- 查看所有的存储引擎
SHOW ENGINES
-- innodb
-- 1.支持事务 2，支持外键 3.支持行级锁

-- myisam存储引擎
CREATE TABLE t30(
	id INT,
	`name` VARCHAR(32)) ENGINE MYISAM
-- 1.添加速度快 2.不支持外键和事务 3.支持表级锁

START TRANSACTION
SAVEPOINT t1
INSERT INTO t30 VALUES(1,'jack');
SELECT * FROM t30
ROLLBACK TO t1
COMMIT

-- memory 存储引擎
-- 1.数据存储在内存中 2.执行速度很快（没有IO读写） 3.默认支持索引（hash）

CREATE TABLE t31(
	id INT,
	`name` VARCHAR(32)) ENGINE MEMORY
	
INSERT INTO t31 VALUES(1,'tom'),(2,'jack'),(3,'hsp');

-- 指令修改存储引擎
ALTER TABLE t31 ENGINE = INNODB