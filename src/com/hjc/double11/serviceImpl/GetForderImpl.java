package com.hjc.double11.serviceImpl;

import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Product;
import com.hjc.double11.service.ForderService;
import com.hjc.double11.service.GetForderService;
import com.hjc.double11.service.SorderService;
public class GetForderImpl implements GetForderService{

	@Override
	public Forder getForder(Forder forder,SorderService sorderService, ForderService forderService, Product product, int num) {
		//把商品信息转化为sorder,并且添加到购物车(判断购物项是否重复)
		forder=sorderService.addSorder(forder,product,num);
		//计算购物的总价格
		forder.setTotal(forderService.cluTotal(forder));
		return forder;
	}
}
