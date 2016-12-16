package com.hjc.double11.dao;

import java.util.List;

import com.hjc.double11.model.Category;
import com.hjc.double11.model.Product;

public interface CategoryDao extends BaseDao<Category> {
	//根据商品类型查询出该类型的所有商品
	public List<Product> findProduct(int id);
}
