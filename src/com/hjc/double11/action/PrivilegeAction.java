package com.hjc.double11.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Sorder;

public class PrivilegeAction implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Forder forder = (Forder) session.getAttribute("forder");
		BigDecimal price = new BigDecimal(0.00);
		for(Sorder sorder: forder.getSorderSet()){
			//日用生活品，满199元优惠20
			if(sorder.getProduct().getCategory().getId()==2){
				price = price.add(sorder.getPrice().multiply(new BigDecimal(sorder.getNumber()))); 
			}
		}
		//日用生活品，满199元优惠20
		if (price.compareTo(new BigDecimal(199.00))>=0) {
			price = price.subtract(new BigDecimal(20.00));
			forder.setTotal(price);
			session.setAttribute("forder", forder);
		}
		BigDecimal privilege = new BigDecimal(0.00);
		if(request.getParameter("privilege")!=null){
			privilege = new BigDecimal(request.getParameter("privilege"));
		}
		return new ModelAndView("user/confirm","privilege",privilege);
	}

}
