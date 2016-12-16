package com.hjc.double11.service;

import java.math.BigDecimal;
import java.util.List;

import com.hjc.double11.model.Pack;

public interface PackService extends BaseService<Pack> {

	public List<Pack> getPackList(int id);
	
	public void deleteThePack(BigDecimal price,int uid);
}
