package com.hjc.double11.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hjc.double11.model.User;
import com.hjc.double11.service.UserService;

public class UserAction extends SimpleFormController {

	private UserService userService;
	
	public UserAction(){
		setCommandClass(User.class);
	}
	
	protected ModelAndView onSubmit(Object command) throws Exception{
		User user = (User)command;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService)context.getBean("userService");
		user = userService.login(user);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		if(user!=null){
			request.getSession().setAttribute("user", user);
			return new ModelAndView(getSuccessView());
		}else {
			String name = null;
			if((User)command!=null){
				name=((User)command).getName();
			}
			request.getSession().setAttribute("error", "用户名或密码错误");
			return new ModelAndView(getFormView(),"name",name);
		}
	}
}
