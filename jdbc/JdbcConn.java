package Chapter25.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

//分析java连接mysql的五种方式
public class JdbcConn {
    //方式一
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();//创建driver对象
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将用户名和密码放入到Properties对象
        Properties properties = new Properties();
        //说明：user和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user","root");//用户
        properties.setProperty("password","qxk");//密码
        Connection connection = driver.connect(url,properties);
        System.out.println(connection);
    }

    //方式二
    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","qxk");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    //方式三 使用DriverManager 替代Driver 进行统一管理
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        //创建url和 user、password
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "qxk";

        DriverManager.registerDriver(driver);//注册Driver驱动

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    //方式四 使用Class。forName 自动完成注册驱动，简化代码
    //这种方式获取连接是使用最多的
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        //使用反射加载Driver类
        //在加载Driver类时，完成注册
        /*
            源码：
            1.静态代码块，在类加载时，会执行一次
            2.DriverManager.registerDriver(new Driver());
            3.因此注册Driver的工作已经完成了
             static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
         */
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

        //创建url和 user、password
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "qxk";
        Connection connection = DriverManager.getConnection(url,user,password);

        System.out.println(connection);
    }

    //方式五,在方式四的基础上改进，增加配置文件，让连接mysql更加灵活
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\software\\Idea\\JavaCode\\HspCode\\src\\Chapter25\\jdbc\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class<?> aClass = Class.forName(driver);//建议写上

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

    }
}
