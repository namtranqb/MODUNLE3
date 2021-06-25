package com.user.dao;

import com.user.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {

    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> searchUser(String country);

    public List<User> selectAllUsers();

//    public boolean acountLogin(String uname, String pw) throws SQLException;

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;



}
