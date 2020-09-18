package com.test.dao;

import com.test.entity.User;

import java.util.List;

public interface UserDao {

    public boolean Login (String customerId, String loginPassword); // 登录

    public boolean register (User user); // 注册

    public List<User> getUserAll (); // 返回所有用户信息

    public boolean delete (int id); // 根据用户id删除用户

    // 更新用户信息
    public boolean update (int id, String customerId, String loginPassword, String customerName, String mobilePhone, String idCard);

}
