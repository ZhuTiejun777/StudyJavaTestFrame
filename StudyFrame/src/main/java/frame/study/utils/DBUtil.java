package frame.study.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

import static java.sql.DriverManager.getConnection;

public class DBUtil {

    private static String oracleDriver;
    private static String url;
    private static String user;
    private static String password;

    // 静态代码块,随着类的加载而执行,而且只执行一次
    // 执行优先级高于非静态的初始化块,它会在类初始化的时候执行一次
    // 执行完成便销毁,它仅能初始化类变量,即static修饰的数据成员
    static {
        ResourceBundle resourceBundle =ResourceBundle.getBundle("oracle");
        oracleDriver = resourceBundle.getString("oracleDriver");
        url = resourceBundle.getString("url");
        user = resourceBundle.getString("user");
        password = resourceBundle.getString("password");
        try {
            Class.forName(oracleDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*static {
        Properties properties = new Properties();
        InputStream inputStream = DBUtil.class.getResourceAsStream("C:\\Users\\Administrator\\Desktop\\git\\StudyJavaTestFrame\\StudyFrame\\src\\main\\resources\\oracle.properties");
        try {
            properties.load(inputStream);
            oracleDriver = properties.getProperty("oracleDriver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(oracleDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close (Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    /*public static Connection getConnection () throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");
        return connection;
    }*/
}
