package com.test.util;

import java.sql.*;
import java.util.ResourceBundle;

public class DBconn {

    private static String oracleDriver;
    private static String url;
    private static String user;
    private static String password;
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("oracle");
        oracleDriver = resourceBundle.getString("oracleDriver");
        url = resourceBundle.getString("url");
        user = resourceBundle.getString("user");
        password = resourceBundle.getString("password");
        try {
            Class.forName(oracleDriver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }*/


    public ResultSet sqlSelect (String sql) {
        // ResultSet resultSet = null;
        try {
            // connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int sqlAddUpdateDelete (String sql) {
        int i = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            i = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public static void close () {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
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

}
