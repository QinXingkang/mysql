package Chapter25.jdbc.batch_;

import Chapter25.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//演示java的批处理

public class Batch_ {
    //传统方法，添加5000条数据到admin2
    @Test
    public void noBatch() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into admin2 values (null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"jack" + i);
            preparedStatement.setString(2,"666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //关闭连接
        JDBCUtils.close(null,preparedStatement,connection);
    }

    //使用批量处理方式添加数据
    @Test
    public void useBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into admin2 values (null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"jack" + i);
            preparedStatement.setString(2,"666");
            //将sql 语句加入到批处理包中
            preparedStatement.addBatch();
            //当有1000条记录时再批量处理
            if ((i + 1) % 1000 == 0){//满1000条sql
                preparedStatement.executeBatch();
                //清空一把
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //关闭连接
        JDBCUtils.close(null,preparedStatement,connection);
    }
}
