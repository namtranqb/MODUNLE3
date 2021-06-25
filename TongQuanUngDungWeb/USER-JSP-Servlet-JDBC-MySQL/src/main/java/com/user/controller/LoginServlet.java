package com.user.controller;

import com.user.dao.UserDAO;
import com.user.model.Account;
import com.user.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginUser(request,response);
    }

    private void loginUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account a = userDAO.loginUser(username,password);

        RequestDispatcher rd;
        if(a == null){

            request.setAttribute("message","Login error! Please again");
            rd = request.getRequestDispatcher("");
            rd.forward(request,response);

        } else {

            if(!username.equals("admin") && !password.equals("admin")){
                List<User> listEdit = userDAO.selectAllUsers();
                request.setAttribute("userList", listEdit);
            }else{
                List<User> listUser = userDAO.selectAllUsers();
                request.setAttribute("listUser", listUser);
            }
            rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request,response);
        }

    }
}
