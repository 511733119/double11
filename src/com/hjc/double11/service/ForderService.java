package com.hjc.double11.service;

import java.math.BigDecimal;

import com.hjc.double11.model.Forder;

public interface ForderService extends BaseService<Forder> {

	//计算购物总价格
	public BigDecimal cluTotal(Forder forder);
}
