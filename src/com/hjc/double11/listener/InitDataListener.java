package com.hjc.double11.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hjc.double11.model.Category;
import com.hjc.double11.model.Product;
import com.hjc.double11.service.CategoryService;
import com.hjc.double11.service.GetForderService;
import com.hjc.double11.service.IOther;
import com.hjc.double11.service.ProductService;

/*
 * 用于项目启动的时候数据初始化
 */
public class InitDataListener implements ServletContextListener {

	private ApplicationContext context = null;
	
	private CategoryService categoryService;
	private ProductService productService;
//	private ChangeBeforeShow changeBeforeShow;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
	    context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	    categoryService = (CategoryService)context.getBean("categoryService");
	    productService = (ProductService)context.getBean("productService");
//	    changeBeforeShow = (ChangeBeforeShow)context.getBean("changeBeforeShowImpl");
//	    System.out.println(categoryService);
	    List<List<Product>> bigList = new ArrayList<List<Product>>();
		//查询出所有类别
		for(Category category :categoryService.query()){
			//根据类别id获取商品信息
			bigList.add(productService.queryByCid(category.getId()));
//			((IOther)changeBeforeShow).doOther(bigList, productService, category.getId());
//			changeBeforeShow.getProductList(bigList, productService, category.getId());
		}
	    
		//把查询的bigList交给application内置对象
		event.getServletContext().setAttribute("bigList", bigList);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}
}
