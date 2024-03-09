package Chapter25.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class PreparedStatementDML {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名和密码
        System.out.print("请输入管理员的名字：");
        String admin_name = scanner.nextLine();
//        System.out.print("请输入管理员的密码：");
//        String admin_pwd = scanner.nextLine();

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
        Connection connection = DriverManager.getConnection(url,user,password);
        //增加语句
//        String sql = "insert into admin values(?,?)";
//        String sql = "update admin set name = ? where `pwd` = ?";
        String sql = "delete from admin where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(2,admin_pwd);
        preparedStatement.setString(1,admin_name);
        //执行dml 语句使用 executeUpdate
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败");
    }
}
