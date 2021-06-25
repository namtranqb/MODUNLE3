package com.example.WebCalculator;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Calculator", value = "/calculator")
public class Calculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("b"));
        String group1 = req.getParameter("group1");
        double ketqua = 0;

       switch (group1) {
           case "+":
               ketqua = a + b;
               break;
           case "-":
               ketqua = a - b;
               break;
           case "*":
               ketqua = a * b;
               break;
           case "^":
               if(b>0){
                   ketqua = 1;
                   for (int i = 1; i <= b ; i++) {
                       ketqua = ketqua * a;
                   }
               }
               break;
           case "%":
               ketqua = a % b;
               break;
           case "/":

               if(b!=0){
                   ketqua = a / b;

               }else
                    throw new RuntimeException("Khong co phep chia cho 0");
               break;
       }

       req.setAttribute("a",a);
       req.setAttribute("b",b);
       req.setAttribute("group1",group1);
       req.setAttribute("ketqua",ketqua);

       RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
       requestDispatcher.forward(req,resp);
    }
}