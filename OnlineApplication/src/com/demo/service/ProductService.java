package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.pojo.Category;

public interface ProductService {

	List<Category> getCategory() throws SQLException;

}
