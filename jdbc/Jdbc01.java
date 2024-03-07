package Chapter25.jdbc;

//这是第一个Jdbc程序，完成简单的操作

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {

        //前置工作：在项目下创建一个文件夹libs
        // 将mysql.jar拷贝到该目录下，加入到项目中
        //1.注册驱动
        Driver driver = new Driver();//创建driver对象

        //2.得到连接
        //(1)jdbc:mysql:// 规定好表示协议，通过jdbc的方式连接mysql
        //(2)localhost 表示主机，也可以写一个IP地址
        //(3)3306表示监听的端口
        //(4)hsp_db02 表示连接到mysql的hsp_db02这个数据库
        //(5)mysql的连接本质就是前面学过的socket的连接
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将用户名和密码放入到Properties对象中
        Properties properties = new Properties();
        properties.setProperty("user","root");//用户名
        properties.setProperty("password","qxk");//密码

        Connection connect = driver.connect(url, properties);

        //3.执行sql
        //String sql = "insert into actor values(null,'韩顺平','男','1970-11-11','111')";
        //String sql = "update actor set name = '周星驰' where id = 1";
        String sql = "delete from actor where id = 1";
        //statement 用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);// 如果是dml语句，返回的就是影响的行数

        System.out.println(rows > 0 ? "成功" : "失败");

        //4.关闭连接资源
        statement.close();
        connect.close();

    }
}
