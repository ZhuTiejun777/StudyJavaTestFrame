package com.test.dao;

import com.test.entity.User;
import com.test.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    private final DBconn dBconn = new DBconn();

    public boolean Login (String customerId, String loginPassword) {
        boolean flag = false;
        String sql = "select login_Password from etc_virtual_account where customer_id = '" + customerId + "'";
        try {
            ResultSet resultSet = dBconn.sqlSelect(sql);
            while (resultSet.next()) {
                if (resultSet.getString("login_Password").equals(loginPassword)) {
                    flag = true;
                }
            }
            DBconn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean register (User user) {
        boolean flag = false;
        String sql = "insert into etc_virtual_account (id, customerId, loginPassword, customerName, mobilePhone, idCard) values ('" +
                user.getId() + "', '" + user.getCustomerId() + "', '" + user.getLoginPassword() + "', '" + user.getCustomerName() + "', '" + user.getMobilePhone() + "', '" + user.getIdCard() + "'";
        int number = dBconn.sqlAddUpdateDelete(sql);
        if (number > 0) {
            flag = true;
        }
        DBconn.close();
        return flag;
    }

    public List<User> getUserAll () {
        List<User> list = new ArrayList<User>();
        String sql = "select id, customerId, loginPassword, customerName, mobilePhone, idCard from etc_virtual_account";
        try {
            ResultSet resultSet = dBconn.sqlSelect(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setCustomerId(resultSet.getString("customer_id"));
                user.setLoginPassword(resultSet.getString("login_password"));
                user.setCustomerName(resultSet.getString("customer_name"));
                user.setMobilePhone(resultSet.getString("mobilephone"));
                user.setIdCard(resultSet.getString("idcard"));
                list.add(user);
            }
            DBconn.close();
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean delete (int id) {
        boolean flag = false;
        String sql = "delete from etc_virtual_account where id = " + id;
        int number = dBconn.sqlAddUpdateDelete(sql);
        if (number > 0) {
            flag = true;
        }
        DBconn.close();
        return flag;
    }

    public boolean update (int id, String customerId, String loginPassword, String customerName, String mobilePhone, String idCard) {
        boolean flag = false;
        String sql = "update etc_virtual_account set customer_id = '" + customerId +
                "', login_password = '" + loginPassword +
                "', customer_name = '" + customerName +
                "', mobilephone = '" + mobilePhone +
                "', idcard = '" + idCard + " where id = " + id;
        int number = dBconn.sqlAddUpdateDelete(sql);
        if (number > 0) {
            flag = true;
        }
        return flag;
    }

}
