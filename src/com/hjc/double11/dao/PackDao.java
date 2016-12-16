package com.hjc.double11.dao;

import java.math.BigDecimal;
import java.util.List;

import com.hjc.double11.model.Pack;
import com.hjc.double11.model.Sorder;

public interface PackDao extends BaseDao<Pack> {

	//获得优惠券列表
	public List<Pack> getPackList(int id);
	
	//购买完成后删除优惠券
	public void deleteThePack(BigDecimal price,int uid);
}
