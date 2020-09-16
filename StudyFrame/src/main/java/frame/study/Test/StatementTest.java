package frame.study.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class StatementTest {

    @Test
    public void test1 () throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接Connection对象
        Connection connection = getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");
        //得到执行SQL语句的Statement对象
        Statement statement = connection.createStatement();
        //执行SQL语句，这里是执行查询语句，得到一个虚拟表的结果对象
        ResultSet resultSet = statement.executeQuery("select count(1) from etc_card");
        //对结果进行处理，这里是打印
        String result;
        while (resultSet.next()) {
            result = resultSet.getObject(1).toString();
            System.out.println(result);
        }
        //关闭连接，节约资源
        resultSet.close();
        statement.close();
        connection.close();


    }

    @Test
    public void test2 () throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接Connection对象
        Connection connection = getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");
        //得到执行SQL语句的Statement对象
        Statement statement = connection.createStatement();
        //执行SQL语句，这里是执行查询语句，得到一个虚拟表的结果对象
        Boolean resultSet = statement.execute("select count(1) from etc_virtual_account");
        //对结果进行处理，这里是打印
        System.out.println(resultSet);
        //关闭连接，节约资源
        statement.close();
        connection.close();
    }

    @Test
    public void test3 () throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接Connection对象
        Connection connection = getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");
        //得到执行SQL语句的Statement对象
        Statement statement = connection.createStatement();
        //执行SQL语句，这里是执行查询语句，得到一个虚拟表的结果对象
        ResultSet resultSet = statement.executeQuery("select count(1) from ETC_VEHICLE_MANAGE");
        //对结果进行处理，这里是打印
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1));
        }
        //关闭连接，节约资源
        resultSet.close();
        statement.close();
        connection.close();
    }


    @Test
    public void test4 () throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");
        Statement statement = connection.createStatement();
        int resultSet = statement.executeUpdate("update etc_tmp_consumptionflow ss set  ss.contracting_agency = 'zjport' where to_char(create_time, 'yyyymmdd') = 20200914");
        System.out.println(resultSet);
        statement.close();
        connection.close();
    }
}
