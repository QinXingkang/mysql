package Chapter25.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcExercise {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\software\\Idea\\Javacode\\HspCode\\src\\Chapter25\\jdbc\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class<?> aClass = Class.forName(driver);

        Connection connection = DriverManager.getConnection(url,user,password);

//        String sql = "insert into news values(3,'qxk','1')";
        String sql = "delete from news where id = 3";

        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");


    }
}
