package Chapter25.jdbc.preparedstatement_;

import com.mysql.fabric.ServerMode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

//演示PreparedStatement使用
public class PreparedStatement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名和密码
//        System.out.print("请输入管理员的名字：");
//        String admin_name = scanner.nextLine();
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

        //3.得到PreparedStatement
        //3，1 组织SQL语句
        String sql = "select * from admin";
        //3.2 preparedStatement 对象实现了 PreparedStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给 ? 赋值
//        preparedStatement.setString(1,admin_name);
//        preparedStatement.setString(2,admin_pwd);

        //4. 执行select语句 使用 executeQuery语句
        //  如果执行的是dml(update, insert, delete)就要用executeUpdate()语句
        //  这里执行查询的时候，不用再写sql，因为上面已经被preparedStatement处理过了
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){//如果查询到一条记录，则说明该管理员存在
//            System.out.println("恭喜，登录成功");
            System.out.print(resultSet.getString(1));
            System.out.print(" ");
            System.out.print(resultSet.getString(2));
        }else{
            System.out.println("对不起，登录失败");
        }


        //关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
