package com.hjc.double11.serviceImpl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Sorder;
import com.hjc.double11.service.ForderService;

/*
 * 模块自身的业务逻辑
 */
@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {

	@Override
	public BigDecimal cluTotal(Forder forder) {
		BigDecimal total = new BigDecimal(0.00);
		for(Sorder temp:forder.getSorderSet()){
			total=total.add(temp.getPrice().multiply(new BigDecimal(temp.getNumber())));
		}
		return total;
	}

}
