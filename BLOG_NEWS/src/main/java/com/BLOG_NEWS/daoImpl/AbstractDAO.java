package com.BLOG_NEWS.daoImpl;

import com.BLOG_NEWS.dao.GenericDAO;
import com.BLOG_NEWS.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

    protected Connection getConnection(){
        final String URL = "jdbc:mysql://localhost:3306/blog_news";
        final String USERNAME = "root";
        final String PASSWORD = "admin";
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = getConnection();
            statement = connection.prepareStatement(sql);

            // set parameter()
            setParameter(statement,parameters);

            resultSet = statement.executeQuery();
            while(resultSet.next()){
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;

        }catch (SQLException e){
            return null;
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException throwables) {
                return null;
            }
        }
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try{
            for(int i = 0; i< parameters.length; i++){
                Object parameter = parameters[i];
                int index = i + 1;
                if(parameter instanceof String){
                    statement.setString(index,(String) parameter);
                }
                if(parameter instanceof Integer){

                    statement.setInt(index,(int) parameter);
                }
            }
        }catch (SQLException ex){

        }


    }
}
