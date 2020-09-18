package com.test.servlet;

import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;
import com.test.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String customerId = request.getParameter("customerId"); //获取jsp页面传过来的参数
        String loginPassword = request.getParameter("loginPassword");
        String customerName = request.getParameter("customerName");
        String mobilePhone = request.getParameter("mobilePhone");
        String idCard = request.getParameter("idCard");

        User user = new User(); //实例化一个对象，组装属性
        user.setCustomerId(customerId);
        user.setLoginPassword(loginPassword);
        user.setCustomerName(customerName);
        user.setMobilePhone(mobilePhone);
        user.setIdCard(idCard);

        UserDao userDao = new UserDaoImpl();

        if(userDao.register(user)){
            request.setAttribute("username", customerId);  //向request域中放置参数
            //request.setAttribute("xiaoxi", "注册成功");
            request.getRequestDispatcher("/denglu.jsp").forward(request, response);  //转发到登录页面
        }else{

            response.sendRedirect("index.jsp");//重定向到首页
        }
    }

}
