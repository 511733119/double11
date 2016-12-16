package com.hjc.double11.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.hjc.double11.daoImpl.BaseDaoImpl;
import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Pack;
import com.hjc.double11.model.Product;
import com.hjc.double11.model.Sorder;
import com.hjc.double11.model.User;
import com.hjc.double11.service.IOther;
import com.hjc.double11.service.PackService;

public class OtherIntroduction extends BaseDaoImpl<Pack> implements IntroductionInterceptor,IOther {


	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		if(implementsInterface(methodInvocation.getMethod().getDeclaringClass())){
			return methodInvocation.getMethod().invoke(this, methodInvocation.getArguments());
		}else {
			return methodInvocation.proceed();
		}
	}

	@Override
	public boolean implementsInterface(Class<?> myclass) {
		return myclass.isAssignableFrom(IOther.class);
	}
	//双十一打折
	@Override
	public void change( Product product) {
		//如果是家用电器，打8折
		if(product.getCategory().getId()==1){
			BigDecimal price = new BigDecimal(0.00);
			price = price.add(product.getPrice().multiply(new BigDecimal(0.80)));
			//取小数点后2位
			price = price.setScale(2,BigDecimal.ROUND_HALF_UP); 
			product.setPrice(price);
		}
		//如果是食品,9折，满100元返5元优惠卷
		if(product.getCategory().getId()==3){
			BigDecimal price = new BigDecimal(0.00);
			price = price.add(product.getPrice().multiply(new BigDecimal(0.90)));
			//取小数点后2位
			price = price.setScale(2,BigDecimal.ROUND_HALF_UP); 
			product.setPrice(price);
		}
		//如果是手机、数码产品,满1000元返20元优惠卷
		//如果是日用生活品,满199元优惠20
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PackService packService = (PackService)context.getBean("packService");
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		User user = (User)request.getSession().getAttribute("user");
		List<Pack> list = null;
		//在购物车里列出所拥有的优惠券并在下单时可进行选择
		if(user!=null){
			list = packService.getPackList(user.getId());
		}
		request.setAttribute("packList", list);
	}

	@Override
	public void savePack(Forder forder) {
		System.out.println("赠送优惠券");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PackService packService = (PackService)context.getBean("packService");
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
//		Forder forder = (Forder) session.getAttribute("forder");
		BigDecimal price = new BigDecimal(0.00); //食品所购买总额
		BigDecimal price2 = new BigDecimal(0.00);	//手机、数码产品所购买总额
		
		for(Sorder sorder: forder.getSorderSet()){
			//食品,满100元返5元优惠卷
			if(sorder.getProduct().getCategory().getId()==3){
				price = price.add(sorder.getPrice().multiply(new BigDecimal(sorder.getNumber()))); 
			}
			//手机、数码产品,满1000元返20元优惠卷
			if(sorder.getProduct().getCategory().getId()==4){
				price2 = price.add(sorder.getPrice().multiply(new BigDecimal(sorder.getNumber()))); 
			}
		}
		//食品如果满100元，送5元优惠券到账户
		if(price.compareTo(new BigDecimal(100.00))>=0){
			User user = (User)session.getAttribute("user");
			packService.save(new Pack(new BigDecimal(5.00),user));
		}
		//手机、数码产品如果满1000元返20元优惠卷到账户
		if(price2.compareTo(new BigDecimal(1000.00))>=0){
			User user = (User)session.getAttribute("user");
			packService.save(new Pack(new BigDecimal(20.00),user));
		}
	}

	//购买成功时，如使用了优惠券，则删除所使用的优惠券
	//并在购买时购物车的价格减去优惠券的钱为所需支付的钱
	@Override
	public void beforeSaveForder(Forder forder, BigDecimal privilege,User user) {
		forder.setTotal(forder.getTotal().subtract(privilege));
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PackService packService = (PackService)context.getBean("packService");
		packService.deleteThePack(privilege,user.getId());
	}
}
