package com.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.pojo.Category;
import com.demo.pojo.Product;

public class CategoryDAOImpl implements CategoryDAO {
	private PreparedStatement psGetAll,psGetCategory;

	public CategoryDAOImpl() {
		try {
			psGetAll = DBUtiil.getConnection().prepareStatement("select * from category");
			psGetCategory=DBUtiil.getConnection().prepareStatement("select * from category where cid=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Category> getAll() throws SQLException {
		List<Category> list = new ArrayList<Category>();

		ResultSet rs = psGetAll.executeQuery();
		while (rs.next()) {
			list.add(new Category(rs.getInt("cid"), rs.getString("cname"), rs.getString("imageUrl")));
		}

		return list;
	}

	@Override
	public Category getCategory(int cid) throws SQLException {
		
		
		Category category =null;
		psGetCategory.setInt(1, cid);
			ResultSet rs = psGetCategory.executeQuery();
			if (rs.next()) {
				category=new Category(rs.getInt("cid"),rs.getString("cname"),rs.getString("imageUrl"));
				return category;
			}
			return null;
			
	}

}
