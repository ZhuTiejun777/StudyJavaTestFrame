package frame.study.Test;

import frame.study.utils.DBUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDemo2 {


    @Test
    public void test1 () {

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from etc_virtual_account");
            while (resultSet.next()) {
                System.out.println(resultSet.getObject(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
