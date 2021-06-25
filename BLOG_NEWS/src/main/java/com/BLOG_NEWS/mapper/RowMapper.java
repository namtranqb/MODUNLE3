package com.BLOG_NEWS.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T mapRow(ResultSet rs);
}
