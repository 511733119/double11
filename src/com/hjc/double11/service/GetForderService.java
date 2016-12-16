package com.hjc.double11.service;

import com.hjc.double11.model.Forder;
import com.hjc.double11.model.Product;

public interface GetForderService {

	public Forder getForder(Forder forder,SorderService sorderService,ForderService forderService,Product product,int num);
}
