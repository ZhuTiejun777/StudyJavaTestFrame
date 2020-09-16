package frame.study.login;

import frame.study.utils.DBUtil;

import java.sql.*;

public class DoLogin {

    public static Boolean LoginVerify (String user, String password) {
        Connection connection;
        // Statement statement;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String result = null;
        try {
            connection = DBUtil.getConnection();
            /*statement = connection.createStatement();
            resultSet = statement.executeQuery("select login_password from etc_virtual_account where customer_id = '" + user + "'");*/
            String sql = "select login_password from etc_virtual_account where customer_id =?";
            preparedStatement = connection.prepareStatement(sql);
            // 给SQL中的?赋值,有几个?就要写几个设置语句?在这里是占位符的作用
            preparedStatement.setString(1, user);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getObject(1).toString();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (result.equals(password)) {
            return true;
        }
        return false;
    }
}
