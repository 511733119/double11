package com.hjc.double11.dao;

import java.util.List;


public interface BaseDao<T> {

	public boolean save(T t);
	
	public void update(T t) ;
	
	public void delete(int id) ;
	
	public T get(int id) ;
	
	public List<T>  query();

}
