package com.hjc.double11.service;

import java.math.BigDecimal;

import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Product;
import com.hjc.double11.model.User;

public interface IOther {

	//打折
	public void change( Product product);
	
	//保存购买时赠送的优惠券
	public void savePack(Forder forder);
	
	//购买成功时，如使用了优惠券，则删除所使用的优惠券
	//并在购买时购物车的价格减去优惠券的钱为所需支付的钱
	public void beforeSaveForder(Forder forder, BigDecimal privilege,User user);
}
