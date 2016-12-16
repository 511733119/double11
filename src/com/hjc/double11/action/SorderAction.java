package com.hjc.double11.action;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Product;
import com.hjc.double11.model.Sorder;
import com.hjc.double11.service.ForderService;
import com.hjc.double11.service.GetForderService;
import com.hjc.double11.service.IOther;
import com.hjc.double11.service.ProductService;
import com.hjc.double11.service.SorderService;
import com.hjc.double11.serviceImpl.OtherIntroduction;

public class SorderAction implements Controller{

	private String viewPage;
	
	private SorderService sorderService;
	
	private ProductService productService;
	
	private ForderService forderService;
	
	private GetForderService getForderService;
	
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		sorderService = (SorderService)context.getBean("sorderService");
		productService = (ProductService)context.getBean("productService");
		forderService = (ForderService)context.getBean("forderService");
		getForderService = (GetForderService)context.getBean("getForderImpl");
		HttpSession session = request.getSession();
		
		//获取类别id
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = productService.get(id);
		//判断当前session是否有购物车，如果没有则创建
		if(session.getAttribute("forder")==null){
			//创建新购物车，存储到session中
			session.setAttribute("forder", new Forder(new HashSet<Sorder>()));
		}
		Forder forder = (Forder)session.getAttribute("forder");
		//获得购物数量
		int num = Integer.parseInt(request.getParameter("number"));
		
		//执行双十一代码,改变价格
	    ((IOther)getForderService).change( product);
	    
		//添加新购物项，并返回新的购物车
		forder = getForderService.getForder(forder, sorderService, forderService, product, num);
		
		//把新的购物车存储到session中
		session.setAttribute("forder", forder);
//		int number=0;
//		for(Sorder sorder : forder.getSorderSet()){
//			number += sorder.getNumber();
//		}
//		session.setAttribute("number",number);
		return new ModelAndView(viewPage);
	}
}
