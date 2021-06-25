package com.BLOG_NEWS.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewModel> {
    @Override
    public NewModel mapRow(ResultSet resultSet) {
        NewModel news = new NewModel();
        try{
            news.setId(resultSet.getInt("id"));
            news.setName(resultSet.getString("new_name"));
            news.setPost_date(resultSet.getDate("post_date"));
            return news;
        }catch (SQLException e){
            return null;
        }
    }
}
