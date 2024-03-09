package Chapter25.jdbc.datasource;

import Chapter25.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class conQuestion {
    @Test
    //代码 连接mysql 5000次

    //看看连接-关闭 connection会耗用多少时间
    public void testCon(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //使用传统的jdbc方式，得到连接
            Connection connection = JDBCUtils.getConnection();

            //关闭
            JDBCUtils.close(null,null,connection);
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}
