package com.hjc.double11.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hjc.double11.model.Product;
import com.hjc.double11.service.ProductService;

public class ProductAction implements Controller{

	private String viewPage;
	private ProductService productService;
	
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService = (ProductService)context.getBean("productService");
		//获取类别id
		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.println("categoryService:"+categoryService);
		Product product = productService.get(id);
		return new ModelAndView(viewPage,"product", product);
	}

}

