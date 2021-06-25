package com.servlet;

import com.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Van Hoang","1983-08-21","Ha Noi"));
        customerList.add(new Customer("Nguyen Van Nam","1983-08-21","Hue"));
        customerList.add(new Customer("Nguyen Thai Hoa","1983-08-22","Ha Nam"));
        customerList.add(new Customer("Tran Dang Khoa","1983-05-21","Trung Quoc"));
        customerList.add(new Customer("Nguyen Dinh Thi","1983-06-21","Da Nang"));
        request.setAttribute("customerList",customerList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
