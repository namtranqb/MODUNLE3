package com.user.dao;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.user.model.Account;
import com.user.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO implements IUserDAO{







    public UserDAO() {
    }

    protected static Connection getConnection(){

        final String jdbcURL="jdbc:mysql://localhost:3306/demo";
        final String jdbcUsername = "root";
        final String jdbcPassword = "admin";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    private static final String INSERT_USERS_SQL="INSERT INTO users"+"(fullName,email,country)VALUES"+"(?,?,?);";
    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1,user.getFullName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

    }

    private static final String SELECT_USER_BY_ID="select id,fullName,email,country from users where id=?";
    @Override
    public User selectUser(int id) {
        User user = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    private static final String SEARCH_USERS_BY_KEYWORD ="select * from users where country like ? or fullName like ? or email like ?";
    @Override
    public List<User> searchUser(String keyword) {
        List<User> lists = new ArrayList<>();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_BY_KEYWORD);){
            preparedStatement.setString(1,"%"+keyword+"%");
            preparedStatement.setString(2,"%"+keyword+"%");
            preparedStatement.setString(3,"%"+keyword+"%");
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                lists.add(new User(id,name,email,country));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lists;
    }

    private static final String SELECT_ALL_USERS="select * from users";
    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("fullName");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id,name,email,country));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return users;
    }

    private static final String DELETE_USERS_SQL="delete from users where id=?";
    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }

        return rowDeleted;
    }

    private static final String UPDATE_USERS_SQL="update users set fullName=?,email=?,country=? where id=?";
    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private static final String SORT_BY_NAME = "select * from users order by fullName";
    public List<User> sortByName(){
        List<User> listSort = new ArrayList<>();
        try(Connection connection = getConnection();PreparedStatement preparedStatement = getConnection().prepareStatement(SORT_BY_NAME)){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                listSort.add(new User(id,fullName,email,country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listSort;
    }



    private static final String COMPACT_SORT = "select * from users where country like ? or fullName like ? or email like ? order by fullName";
    public List<User> compactSort( String keywordSort){
        List<User> listCompactSort = new ArrayList<>();
        try(Connection connection = getConnection();PreparedStatement preparedStatement = getConnection().prepareStatement(COMPACT_SORT)){
            preparedStatement.setString(1,"%"+keywordSort+"%");
            preparedStatement.setString(2,"%"+keywordSort+"%");
            preparedStatement.setString(3,"%"+keywordSort+"%");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                listCompactSort.add(new User(id,fullName,email,country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listCompactSort;
    }
    



//    public boolean acountLogin(String uname, String pw) throws SQLException{
//        boolean checkLogin;
//        try(Connection connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN)){
//            preparedStatement.setString(1,uname);
//            preparedStatement.setString(2,pw);
//            checkLogin = preparedStatement.executeUpdate() > 0;
//        }
//        return checkLogin;
//    }
private static final String CHECK_LOGIN ="Select `username`,pass from acount where `username` = ? and pass = ?";

    public Account loginUser(String uname, String pw){

        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN);
        ){
            preparedStatement.setString(1,uname);
            preparedStatement.setString(2,pw);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return new Account(uname,pw);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

