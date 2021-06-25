package com.EXAM_MODUNLE3.DAOImpl;

import com.EXAM_MODUNLE3.DAO.IEmployeeDAO;
import com.EXAM_MODUNLE3.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {



    protected  static Connection getConnection(){

        final String jdbcURL="jdbc:mysql://localhost:3306/exam_modunle3";
        final String jdbcUsername = "root";
        final String jdbcPassword = "admin";
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    final String SELECT_ALL ="select id,`group`,fullname,gender,phone_number from employees";
    @Override
    public List<Employee> displayAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try( Connection connection = getConnection();
        PreparedStatement statement =connection.prepareStatement(SELECT_ALL);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String group = rs.getString("group");
                String fullname = rs.getString("fullname");
                String gender = rs.getString("gender");
                String phone_number = rs.getString("phone_number");

                employees.add(new Employee(id,group,fullname,gender,phone_number));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employees;
    }


    private static final String SELECT_EMPLOYEE_BY_ID="select * from employees where id=?";
    public Employee selectEmployee(int id) {
        Employee employee = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String group = rs.getString("group");
                String fullname = rs.getString("fullname");
                Date dob = rs.getDate("dob");
                String gender = rs.getString("gender");
                String phone_number = rs.getString("phone_number");
                String identity = rs.getString("identity");
                String email = rs.getString("email");
                String address = rs.getString("address");

                employee = new Employee(id,group,fullname,dob,gender,phone_number,identity,email,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }



    private static final String INSERT_EMPLOYEE_SQL="insert into employees (`group`,fullname,dob,gender,phone_number,`identity`, email, address) values (?,?,?,?,?,?,?,?)";
    public void insertEmployee(Employee employee) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);){
            statement.setString(1,employee.getGroup());
            statement.setString(2,employee.getFullname());
            statement.setDate(3,employee.getDob());
            statement.setString(4,employee.getGender());
            statement.setString(5, employee.getPhone_number());
            statement.setString(6,employee.getIdentity());
            statement.setString(7,employee.getEmail());
            statement.setString(8,employee.getAddress());

            statement.executeUpdate();


        }
    }

    private static final String DELETE_EMPLOYEE_SQL="delete from employees where id=?";
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }

        return rowDeleted;
    }

    private static final String UPDATE_EMPLOYEE_SQL="update employees set `group`=?,fullname=?,dob=?,gender=?,phone_number=?,`identity`=?, email=?, address=? where id = ?";
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);){
            statement.setString(1,employee.getGroup());
            statement.setString(2,employee.getFullname());
            statement.setDate(3,employee.getDob());
            statement.setString(4,employee.getGender());
            statement.setString(5, employee.getPhone_number());
            statement.setString(6,employee.getIdentity());
            statement.setString(7,employee.getEmail());
            statement.setString(8,employee.getAddress());
            statement.setInt(9,employee.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private final String SEARCH_EMPLOYEE = "SELECT * FROM employees WHERE `fullname` LIKE ? OR `id` LIKE ?;";
    public List<Employee> search(String search) throws SQLException{
        String search2 = "%"+search+"%";
        System.out.println(search2);
        List<Employee> employee = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SEARCH_EMPLOYEE);
        ){
            System.out.println(statement);
            statement.setString(1,search2);
            statement.setString(2,search2);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String group = rs.getString("group");
                String fullname = rs.getString("fullname");
                Date dob = rs.getDate("dob");
                String gender = rs.getString("gender");
                String phone_number = rs.getString("phone_number");
                String identity = rs.getString("identity");
                String email = rs.getString("email");
                String address = rs.getString("address");

                employee.add(new Employee(id,group,fullname,dob,gender,phone_number,identity,email,address));
            }
        }
        return employee;
    }

}
