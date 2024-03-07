package Chapter25.jdbc.myjdbc;

public class TestJDBC {
    public static void main(String[] args) {
        //完成对mysql的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        jdbcInterface.getConnection();//通过接口来调用实现类[动态绑定]
        jdbcInterface.crud();
        jdbcInterface.close();

        JdbcInterface jdbcInterface1 = new OracleJdbcimpl();
        jdbcInterface1.getConnection();//通过接口来调用实现类[动态绑定]
        jdbcInterface1.crud();
        jdbcInterface1.close();
    }
}
