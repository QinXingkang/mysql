-- 演示数学相关的函数

-- 绝对值
SELECT ABS(-10);

-- 十进制转二进制
SELECT BIN(10) FROM DUAL;

-- CEILING(number2) 向上取整
SELECT CEILING(-15.1) FROM DUAL;

-- 进制转换 十进制的8 转为 二进制
SELECT CONV(8,10,2);

-- FLOOR(number2) 向下取整
SELECT FLOOR(15.1) FROM DUAL;
SELECT FLOOR(-15.1) FROM DUAL;

-- FORMAT(number,decimal_places) 保留小数位数
SELECT FORMAT(78.123458,2) FROM DUAL;

-- HEX(DecimalNumber) 转十六进制
SELECT HEX(10) FROM DUAL;

-- LEAST () 多个里面最小值
SELECT LEAST(0,1,-10,4) FROM DUAL;

-- MOD() 求余数
SELECT MOD(10,3) FROM DUAL;

-- RAND([seed]) 返回随机数 范围0 < v < 1.0
SELECT RAND() FROM DUAL;

