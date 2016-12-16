package com.hjc.double11.service;

import java.util.List;


public interface BaseService<T> {

	public boolean save(T t);
	
	public void update(T t) ;
	
	public void delete(int id) ;
	
	public T get(int id) ;
	
	public List<T>  query();
}
