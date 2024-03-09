package Chapter25.jdbc.transaction_;

import Chapter25.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//演示JDBC中如何使用事务
public class Transaction_ {

    //没有使用事务
    @Test
    public void noTransaction(){
        //转账的业务
        //1.得到连接
        Connection connection = null;

        //2.组织Sql语句
        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";

        //3.创建一个PreparedStatement对象
        PreparedStatement preparedStatement = null;
        try {
            //在默认情况下，Connection对象是默认自动提交commit
            connection = JDBCUtils.getConnection();
            //执行第一条sql
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            int i = 1/0;
            //执行第二条sql
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }

    @Test
    public void useTransaction(){
        //转账的业务
        //1.得到连接
        Connection connection = null;

        //2.组织Sql语句
        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";

        //3.创建一个PreparedStatement对象
        PreparedStatement preparedStatement = null;
        try {
            //在默认情况下，Connection对象是默认自动提交commit
            //将Connection设置为不自动提交
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);//相当于开启了事务
            //执行第一条sql
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

//            int i = 1/0;
            //执行第二条sql
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            //这里提交事务
            connection.commit();
        } catch (SQLException e) {
            //这里我们可以进行回滚，即撤销执行的SQL语句
            System.out.println("执行发生了异常，撤销执行的SQL");
            try {
                connection.rollback();//在没有设置回滚点时，默认回滚到事务的开始
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
