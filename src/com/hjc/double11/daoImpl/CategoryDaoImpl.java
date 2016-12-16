package com.hjc.double11.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjc.double11.dao.CategoryDao;
import com.hjc.double11.model.Category;
import com.hjc.double11.model.Product;

/*
 * 模块自身的业务逻辑
 */
@SuppressWarnings("unchecked")
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	
	public CategoryDaoImpl(){
		super();
	}

	@Override
	public List<Product> findProduct(int id) {
		String hql ="FROM Product p JOIN FETCH p.category WHERE p.category.id=:cid";
		//存放商品
		List<Product> productList = new ArrayList<Product>();
		productList = getSession().createQuery(hql)
						.setInteger("cid", id)
						.list();
		
		return productList;
	}
}
