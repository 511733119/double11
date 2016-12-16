package com.hjc.double11.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hjc.double11.model.User;
import com.hjc.double11.service.UserService;

@SuppressWarnings("deprecation")
public class RegisterAction extends SimpleFormController{

	private UserService userService;
	
	public RegisterAction() {
		setCommandClass(User.class);
		setCommandName("User");
	}
	@Override
	protected ModelAndView onSubmit(Object command,BindException errors) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService)context.getBean("userService");
		User user = (User)command;
		boolean bool = userService.register(user);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession().setAttribute("user", user);
		if(bool){
			return new ModelAndView(getSuccessView());
		}else {
			return new ModelAndView(getFormView());
		}
		
	}
}
