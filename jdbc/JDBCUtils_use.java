package Chapter25.jdbc;

import Chapter25.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//该类演示如何使用JDBCUtils工具类 完成dml和 select
public class JDBCUtils_use {

    @Test
    public void testSelect(){
        //1.得到连接
        Connection connection = null;

        //2.组织Sql语句
        String sql = "select * from actor";

        ResultSet set = null;

        //3.创建一个PreparedStatement对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            //执行,得到了一个结果集
            set = preparedStatement.executeQuery();

            //遍历该结果集
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(set,preparedStatement,connection);
        }
    }



    @Test
    public void testDML(){//insert, update, delete
        //1.得到连接
        Connection connection = null;

        //2.组织Sql语句
        String sql = "update actor set name = ? where id = ?";

        //3.创建一个PreparedStatement对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,"周星驰");
            preparedStatement.setInt(2,4);
            //执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
