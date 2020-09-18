package com.test.servlet;

import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);

        String customerId = request.getParameter("customerId");
        String loginPassword = request.getParameter("loginPassword");
        String customerName = request.getParameter("customerName");
        String mobilePhone = request.getParameter("mobilePhone");
        String idCard = request.getParameter("idCard");

        System.out.println("------------------------------------" + userId);

        UserDao userDao = new UserDaoImpl();

        if(userDao.update(userId, customerId, loginPassword, customerName, mobilePhone, idCard)){
            request.setAttribute("xiaoxi", "更新成功");
            request.getRequestDispatcher("/Searchall").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }

}
