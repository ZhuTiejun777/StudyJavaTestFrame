package frame.study.JDBCStudy;

import java.sql.*;

public class JDBCDemo1 {

    public static void main(String[] args) throws SQLException {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");
        Statement statement = connection.createStatement();
        // ResultSet resultSet = statement.executeQuery("select vehicle_code from etc_card");
        ResultSet resultSet = statement.executeQuery("select count(1) from etc_card");

        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
