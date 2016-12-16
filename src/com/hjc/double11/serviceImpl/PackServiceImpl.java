package com.hjc.double11.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Pack;
import com.hjc.double11.model.Product;
import com.hjc.double11.model.Sorder;
import com.hjc.double11.service.PackService;
import com.hjc.double11.service.SorderService;

/*
 * 模块自身的业务逻辑
 */
@Service("packService")
public class PackServiceImpl extends BaseServiceImpl<Pack> implements PackService {

	@Override
	public List<Pack> getPackList(int id) {
		return packDao.getPackList(id);
	}

	@Override
	public void deleteThePack(BigDecimal price,int uid) {
		packDao.deleteThePack(price,uid);
	}
}
