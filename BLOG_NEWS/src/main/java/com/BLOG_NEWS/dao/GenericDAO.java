package com.BLOG_NEWS.dao;

import com.BLOG_NEWS.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String SQl, RowMapper<T> rowMapper, Object... parameters);


}
