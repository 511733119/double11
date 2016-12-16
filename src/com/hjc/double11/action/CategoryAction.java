package com.hjc.double11.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hjc.double11.model.Product;
import com.hjc.double11.service.CategoryService;


public class CategoryAction implements Controller{

	private String viewPage;
	
	private CategoryService categoryService;
	
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryService = (CategoryService)context.getBean("categoryService");
		//获取类别id
		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.println("categoryService:"+categoryService);
		List<Product> productList = categoryService.findProduct(id);
		return new ModelAndView(viewPage,"productList", productList);
	}

}
