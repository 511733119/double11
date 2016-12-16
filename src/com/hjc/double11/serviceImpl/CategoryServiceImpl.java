package com.hjc.double11.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hjc.double11.model.Category;
import com.hjc.double11.model.Product;
import com.hjc.double11.service.CategoryService;

/*
 * 模块自身的业务逻辑
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Override
	public List<Product> findProduct(int id) {
		return categoryDao.findProduct(id);
	}

}
