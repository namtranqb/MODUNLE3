package com.BLOG_NEWS.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        CategoryModel category = new CategoryModel();
        try{
            category.setId(resultSet.getInt("id"));
            category.setCategory_name(resultSet.getString("category_name"));
            return category;
        }catch (SQLException e){
            return null;
        }
    }
}
