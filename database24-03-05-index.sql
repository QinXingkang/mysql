-- 演示mysql的索引的使用
-- 创建索引
CREATE TABLE t26(
	id INT,
	`name` VARCHAR(32));
	
-- 查询表是否有索引
SHOW INDEXES FROM t26;

-- 添加索引
-- 添加唯一索引
CREATE UNIQUE INDEX id_index ON t26 (id);

-- 添加普通索引方式1
CREATE INDEX name_index ON t26 (`name`);
-- 如果要添加索引的列的内容会有重复，就使用普通索引
-- 如果要添加索引的列的内容不会有重复，就使用unique索引

-- 添加普通索引方式2
ALTER TABLE t26 ADD INDEX id_index (id);

-- 添加主键索引
CREATE TABLE t27(
	id INT PRIMARY KEY,
	`name` VARCHAR(32),
	grades INT);
	
CREATE INDEX id_index ON t27 (id);

CREATE TABLE t28(
	id INT,
	`name` VARCHAR(32),
	grades INT);
	
ALTER TABLE t28 ADD PRIMARY KEY (id);

-- 删除索引
DROP INDEX id_index ON t26;

SHOW INDEXES FROM t26;

-- 删除主键索引
ALTER TABLE t28 DROP PRIMARY KEY;

-- 修改索引，即先删除再重新添加

-- 查询索引
-- 方式一
SHOW INDEX FROM t27;
-- 方式二
SHOW INDEXES FROM t27;
-- 方式三
SHOW KEYS FROM t27;
-- 方式四
DESC t27;

CREATE TABLE `Order01`(
	id INT PRIMARY KEY,
	goods_name VARCHAR(32),
	customer VARCHAR(32),
	num INT
	);
SHOW INDEXES FROM `Order01`;	
	
CREATE TABLE `Order02`(
	id INT,
	goods_name VARCHAR(32),
	customer VARCHAR(32),
	num INT
	);
ALTER TABLE `Order02` ADD PRIMARY KEY (id);
SHOW INDEXES FROM `Order02`;

CREATE TABLE `Order03`(
	id INT,
	goods_name VARCHAR(32),
	customer VARCHAR(32),
	num INT
	);
ALTER TABLE `Order03` ADD PRIMARY KEY (id);
SHOW INDEXES FROM `Order03`;

CREATE TABLE menu(
	id VARCHAR(32) PRIMARY KEY,
	`name` VARCHAR(32),
	customer_id VARCHAR(32),
	price INT
	);
	
CREATE UNIQUE INDEX customer_id_index ON menu(customer_id);

CREATE TABLE menu02(
	id VARCHAR(32) PRIMARY KEY,
	`name` VARCHAR(32),
	customer_id VARCHAR(32),
	price INT
	);
ALTER TABLE menu02 ADD UNIQUE INDEX customer_id_index (customer_id);

CREATE TABLE sportman01(
	id INT PRIMARY KEY,
	`name` VARCHAR(32));
CREATE INDEX `name_index` ON sportman01 (`name`);

CREATE TABLE sportman02(
	id INT PRIMARY KEY,
	`name` VARCHAR(32));
ALTER TABLE sportman02 ADD INDEX `name_index` (`name`);