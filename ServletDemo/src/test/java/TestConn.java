import com.test.util.DBconn;
import org.junit.jupiter.api.Test;
import sun.security.pkcs11.Secmod;

import java.sql.*;

public class TestConn {

    static String sqlSelect = "select VEHICLE_CODE from ETC_VEHICLE_MANAGE where CUSTOMER_ID = '666666'";
    static String sqlUpdate = "update ETC_VIRTUAL_ACCOUNT set multi_card = '0'";

    @Test
    public void Test1 () throws SQLException, ClassNotFoundException {
        DBconn dBconn = new DBconn();
        ResultSet resultSet = dBconn.sqlSelect(sqlSelect);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1));
        }
        int updateNumber = dBconn.sqlAddUpdateDelete(sqlUpdate);
        System.out.println(updateNumber);
        DBconn.close();
        assert updateNumber == 12304;
       /* Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");

        // Connection connection = DBconn.getConnection();
        // PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Statement statement = connection.createStatement();
        // ResultSet resultSet = preparedStatement.executeQuery();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1));
        }*/
    }
}
