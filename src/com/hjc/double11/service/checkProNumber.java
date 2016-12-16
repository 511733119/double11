package com.hjc.double11.service;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class checkProNumber implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] obj, Object target) throws Throwable {
		System.out.println("aopRUN:"+method+","+obj[0]+","+target);
	}
	
}
