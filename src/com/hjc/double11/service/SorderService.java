package com.hjc.double11.service;

import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Product;
import com.hjc.double11.model.Sorder;

public interface SorderService extends BaseService<Sorder> {

	//添加购物项
	public Forder addSorder(Forder forder,Product product,int num);
	//把product转化为sorder
	public Sorder productToSorder(Product product,int num);
	//根据商品编号更新商品的数量
	public Forder updateSorder(Forder forder,Sorder sorder);
	
}
