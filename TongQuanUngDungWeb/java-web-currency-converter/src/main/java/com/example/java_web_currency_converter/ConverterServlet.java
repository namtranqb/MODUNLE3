package com.example.java_web_currency_converter;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "converterServlet", value = "/convert")
public class ConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        float vnd = rate * usd;

        PrintWriter writer = response.getWriter();

        writer.println("<h1>Rate: " + rate+ "</h1>");
        writer.println("<h1>USD: " + usd+ "</h1>");
        writer.println("<h1>VND: " + vnd+ "</h1>");

    }
}