package com.BLOG_NEWS.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet resultSet) {
        UserModel users = new UserModel();
        try{
            users.setId(resultSet.getInt("id"));
            users.setUsername(resultSet.getString("username"));
            users.setPassword(resultSet.getString("password"));
            users.setEmail(resultSet.getString("email"));
            users.setIsAdmin(resultSet.getInt("is_admin"));
            return  users;
        }catch (SQLException e){
            return null;
        }
    }
}
