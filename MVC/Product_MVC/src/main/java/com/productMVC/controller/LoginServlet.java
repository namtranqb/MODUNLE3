package com.productMVC.controller;

import com.productMVC.model.Product;
import com.productMVC.service.ProductService;
import com.productMVC.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/home")
public class LoginServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        RequestDispatcher rd;
        if(username.equals("admin") && password.equals("admin")){
            session.setAttribute("username", username);
            session.setAttribute("password", password);

            List<Product> products = this.productService.findAll();
            request.setAttribute("products",products);

            rd = request.getRequestDispatcher("/list.jsp");
            rd.forward(request, response);
        }else
            if(username.equals("user") && password.equals("user")) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);

            List<Product> products = this.productService.findAll();
            request.setAttribute("products", products);

            rd = request.getRequestDispatcher("/display.jsp");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }

    }

}
