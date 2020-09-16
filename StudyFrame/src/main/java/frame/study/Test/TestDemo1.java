package frame.study.Test;

import frame.study.Bean.Student;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class TestDemo1 {

    @Test
    public void test1 () throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = getConnection("jdbc:oracle:thin:@192.168.3.55:1521:zjporttest", "etctest", "etctest");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from etc_virtual_account");
        List<Student> list = new ArrayList<Student>();

        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getLong("customer_id"));
            student.setName(resultSet.getString("customer_name"));
            student.setCard(resultSet.getString("idcode"));
            list.add(student);
        }
        //遍历集合
        for (Student student : list) {
            System.out.println(student.toString());
        }
        //关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
