package frame.study.JDBCStudy;

import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

public class JDBCDemo1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //注册驱动
        // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //获取连接Connection对象
        Connection connection = getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");
        /*// 第二种方法
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        getConnection("jdbc:mysql://localhost:3306/mydatabase", info);
        // 第三种方法
        getConnection("jdbc:mysql://localhost:3306/mydatabase?user=root&password=123456");*/


        //得到执行SQL语句的Statement对象
        Statement statement = connection.createStatement();

        //执行SQL语句，这里是执行查询语句，得到一个虚拟表的结果对象
        // ResultSet resultSet = statement.executeQuery("select vehicle_code from etc_card");
        ResultSet resultSet = statement.executeQuery("select count(1) from etc_card");

        //对结果进行处理，这里是打印
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1));
        }

        //关闭连接，节约资源
        resultSet.close();
        statement.close();
        connection.close();

    }
}
