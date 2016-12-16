package com.hjc.double11.action;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hjc.double11.model.Forder;

public class OrderValidator implements Validator{
	
	@Override
	public boolean supports(Class c) {
		return c.equals(Forder.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "null",  "收货地址不能为空");
	}
}
