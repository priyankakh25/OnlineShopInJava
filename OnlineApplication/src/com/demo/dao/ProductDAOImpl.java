package com.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.pojo.Category;
import com.demo.pojo.Product;

public class ProductDAOImpl implements ProductDAO{
	private PreparedStatement psAllProductByCid,pstGetProduct,psAllProduct;
	
	public ProductDAOImpl() {
		try {
			psAllProduct=DBUtiil.getConnection().prepareStatement("select * from product");
			psAllProductByCid=DBUtiil.getConnection().prepareStatement("select * from product where cid=?");
			pstGetProduct=DBUtiil.getConnection().prepareStatement("select * from product where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAllProduct(int cid) throws SQLException {
		List<Product> plist = new ArrayList<Product>();
		psAllProductByCid.setInt(1, cid);
		ResultSet rs = psAllProductByCid.executeQuery();
		while (rs.next()) {
			plist.add(new Product(rs.getInt("pid"),rs.getString("pname"),rs.getInt("qty"),rs.getDouble("price"),rs.getString("imageUrl"),rs.getInt("cid"),rs.getString("brandname"),rs.getString("subcategory"),rs.getString("description"),rs.getString("weight")));
		}

		return plist;
	}
	@Override
	public List<Product> getAllProduct() throws SQLException {
		List<Product> plist = new ArrayList<Product>();
		ResultSet rs = psAllProduct.executeQuery();
		while (rs.next()) {
			plist.add(new Product(rs.getInt("pid"),rs.getString("pname"),rs.getInt("qty"),rs.getDouble("price"),rs.getString("imageUrl"),rs.getInt("cid"),rs.getString("brandname"),rs.getString("subcategory"),rs.getString("description"),rs.getString("weight")));
		}

		return plist;
	}
	@Override
	public Product getProduct(int pid) throws SQLException {
		Product product =null;
		pstGetProduct.setInt(1, pid);
		ResultSet rs = pstGetProduct.executeQuery();
		if (rs.next()) {
			product=new Product(rs.getInt("pid"),rs.getString("pname"),rs.getInt("qty"),rs.getDouble("price"),rs.getString("imageUrl"),rs.getInt("cid"),rs.getString("brandname"),rs.getString("subcategory"),rs.getString("description"),rs.getString("weight"));
			return product;
		}
		return null;
	}	

}
