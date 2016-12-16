package com.hjc.double11.action;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Product;
import com.hjc.double11.model.Sorder;
import com.hjc.double11.model.User;
import com.hjc.double11.service.ForderService;
import com.hjc.double11.service.IOther;
import com.hjc.double11.service.ProductService;

@SuppressWarnings("deprecation")
public class ForderAction extends SimpleFormController{

	private ForderService forderService;
	
	private ProductService productService;
	
	public ForderAction() {
		setCommandClass(Forder.class);
		setCommandName("Forder");
	}
	@Override
	protected ModelAndView onSubmit(Object command,BindException errors) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		forderService = (ForderService)context.getBean("forderService");
		productService = (ProductService)context.getBean("productService");
		
		Forder f = (Forder)command;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();	
		
		Forder forder = (Forder) session.getAttribute("forder");
		User user = (User)session.getAttribute("user");
		forder.setName(f.getName());
		forder.setPhone(f.getPhone());
		forder.setPost(f.getPost());
		forder.setAddress(f.getAddress());
		forder.setUser(user);		//级联入库
		
		//如果用户使用了优惠券,则在保存订单前总额减去优惠券的钱，并删除已使用的优惠券
		if(request.getParameter("privilege")!=null){
			BigDecimal privilege = new BigDecimal(request.getParameter("privilege"));
			if(privilege!=new BigDecimal(0.00)){
				((IOther)forderService).beforeSaveForder(forder, privilege, user);
			}
		}
		
		//下单,保存到数据库
		boolean bool = forderService.save(forder);
		
		//双十一：保存赠送的优惠券到用户中
		((IOther)forderService).savePack(forder);
		
		//删除所购买商品的库存量
		for(Sorder sorder : forder.getSorderSet()){
			//获得某商品对象
			Product product = sorder.getProduct();
			//某商品库存量
			int stock = productService.get(product.getId()).getStock();
			stock = stock - sorder.getNumber();
			product.setStock(stock);
			productService.update(product);
		}
		
		//订单已经生成，删除session中的购物车
		if(bool){
			session.removeAttribute("forder");
			session.setAttribute("forder", new Forder());
			return new ModelAndView(getSuccessView());		
		}else {
			return new ModelAndView(getFormView());
		}

		
	}
}

