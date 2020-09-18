package com.test.servlet;

import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;
import com.test.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchAllServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDao userDao = new UserDaoImpl();
        List<User> userAll = userDao.getUserAll();
        request.setAttribute("userAll", userAll);
        request.getRequestDispatcher("/showall.jsp").forward(request, response);
    }



}
