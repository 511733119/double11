package com.hjc.double11.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hjc.double11.model.Pack;
import com.hjc.double11.model.User;
import com.hjc.double11.service.PackService;

public class TurnToMyPackAction implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PackService packService = (PackService)context.getBean("packService");
		User user = (User)request.getSession().getAttribute("user");
		List<Pack> list = null;
		if(user!=null){
			list = packService.getPackList(user.getId());
		}
		return new ModelAndView("MyPack","packList",list);
	}

}
