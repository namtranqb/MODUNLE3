package com.EXAM_MODUNLE3.controller;

import com.EXAM_MODUNLE3.DAO.IEmployeeDAO;
import com.EXAM_MODUNLE3.DAOImpl.EmployeeDAO;
import com.EXAM_MODUNLE3.model.Employee;

import java.io.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        String search = request.getParameter("search");
        if(action == null){
            action ="";
        }
        try{
            switch (action){
                case "create":
                    showNewForm(request,response);
                    break;
                case "delete":
                        deleteEmployee(request,response);
                        break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "search":
                    if(search!=null){
                            search(request,response);
                        break;
                    }
                default:
                    displayAllEmployee(request,response);
        }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeDAO.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);

        List<Employee> employeeList = employeeDAO.displayAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void displayAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeDAO.displayAllEmployee();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, IOException, ServletException {
        String group = request.getParameter("group");
        String name = request.getParameter("fullname");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String gender = request.getParameter("gender");
        String phone_number = request.getParameter("phone_number");
        String identity = request.getParameter("identity");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Employee employee = new Employee(group,name,dob,gender,phone_number,identity,email,address);
        employeeDAO.insertEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String group = request.getParameter("group");
        String name = request.getParameter("fullname");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String gender = request.getParameter("gender");
        String phone_number = request.getParameter("phone_number");
        String identity = request.getParameter("identity");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Employee employee = new Employee(id,group,name,dob,gender,phone_number,identity,email,address);
        employeeDAO.updateEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String search = request.getParameter("search");
        List<Employee> list = employeeDAO.search(search);
        request.setAttribute("employeeList",list);
        request.setAttribute("keyword",search);
        request.getRequestDispatcher("employee/list.jsp").forward(request,response);
    }



}