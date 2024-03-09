package Chapter25.jdbc.resultset_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//演示select 语句返回 ResultSet。并取出结果
public class Resultset_ {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\software\\Idea\\JavaCode\\HspCode\\src\\Chapter25\\jdbc\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1.注册驱动
        Class<?> aClass = Class.forName(driver);//建议写上

        //2.得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3.得到statement
        Statement statement = connection.createStatement();

        //4.组织Sql语句
        String sql = "select id, name, sex, borndate from actor";
        //执行给定的SQL语句，该语句返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);

        //5.使用while循环取出数据
        while (resultSet.next()){// 让光标向后移动，如果没有更多的行，则返回false
            int id = resultSet.getInt(1);//获取该行的第一列数据
            String name = resultSet.getString(2);//获取该行第二列数据
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        //6.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
