package com.qa.util;

//导入数据包

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author Charlie.chen
 *
 */

public class JDBCUtil {

    // 驱动包名和数据库url
    private static String url = null;
    private static String driverClass = null;
    // 数据库用户名和密码
    private static String userName = null;
    private static String password = null;


    /**
     * 初始化驱动程序
     * 静态代码块中（只加载一次）
     */
    static{
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("oracle");
            //读取信息
            url = resourceBundle.getString("url");
            driverClass = resourceBundle.getString("oracleDriver");
            userName = resourceBundle.getString("user");
            password = resourceBundle.getString("password");

            //注册驱动程序
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("驱程程序注册出错");
        }
    }


    /**
     * 打开数据库驱动连接
     */
    public static Connection getConnection(){
        try {
            Connection connection;
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



    /**
     * 清理环境，关闭连接(顺序:后打开的先关闭)
     */
    public static void close(Connection conn,Statement stmt,ResultSet rs){
        if(rs!=null)
            try {
                rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException(e1);
            }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }



    public static void main(String[] args) {

       Connection connection = null;
       Statement statement = null;
       ResultSet resultSet = null;


       connection = getConnection();
       try {
           statement = connection.createStatement();
            //准备sql操作语句
            String sql= "SELECT * FROM etc_card";
           resultSet = statement.executeQuery(sql);

            //从结果集中提取数据
            while(resultSet.next()){
                 int id  = resultSet.getInt("id");
                 int age = resultSet.getInt("age");
                 String first = resultSet.getString("first");
                 String last = resultSet.getString("last");

                 System.out.print("ID: " + id);
                 System.out.print(", Age: " + age);
                 System.out.print(", First: " + first);
                 System.out.println(", Last: " + last);
            }
          } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }finally{
              close(connection, statement, resultSet);
          }
     }
}