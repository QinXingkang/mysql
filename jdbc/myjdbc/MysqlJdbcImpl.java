package Chapter25.jdbc.myjdbc;

//模拟数据库实现了JDBC接口
public class MysqlJdbcImpl implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("得到 mysql 的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 mysql 增删改查");

    }

    @Override
    public void close() {
        System.out.println("关闭 mysql 的连接");

    }
}
