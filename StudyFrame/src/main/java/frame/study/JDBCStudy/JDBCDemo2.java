package frame.study.JDBCStudy;

import java.sql.*;

public class JDBCDemo2 {

    public static void main(String[] args) {
        //获取连接Connection对象
        Connection connection = null;
        //得到执行SQL语句的Statement对象
        Statement statement = null;
        //执行SQL语句，这里是执行查询语句，得到一个虚拟表的结果对象
        ResultSet resultSet = null;
        try {
            //加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM etc_virtual_account");
            //对结果进行处理，这里是打印
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getObject(1) + "\t" + resultSet.getObject(2) + "\t" + resultSet.getObject(3) + "\t" + resultSet.getObject(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultSet = null; //赶紧垃圾回收
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connection = null;
            }
        }
    }


}

