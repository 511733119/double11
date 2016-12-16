package com.hjc.double11.action;



import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hjc.double11.model.User;

public class RegisterValidator implements Validator{
	
	@Override
	public boolean supports(Class c) {
		return c.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "null",  "收货地址不能为空");
		if(!Pattern.matches("[A-Z]+",user.getName())){
			errors.rejectValue("name", null, null, "会员名必须是大写");
		}
		
		//只能输入0-120的数字
		if(!Pattern.matches("^(0|(\\d{1,2})|((1[0-1]\\d)|(120)))(\\.\\d{1,2}){0,1}$", String.valueOf(user.getAge()))){
			errors.rejectValue("age", null, null, "请输入正确的年龄");
		}
	}
	
}
