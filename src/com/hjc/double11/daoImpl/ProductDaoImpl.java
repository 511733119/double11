package com.hjc.double11.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjc.double11.dao.ProductDao;
import com.hjc.double11.model.Product;

/*
 * 模块自身的业务逻辑
 */
@SuppressWarnings("unchecked")
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		String hql = "FROM Product p LEFT JOIN FETCH p.category WHERE p.name LIKE :name";
		return getSession().createQuery(hql)
			.setString("name", "%"+ name +"%")
			.setFirstResult((page-1)*size)
			.setMaxResults(size)
			.list();                               
	}
	
	@Override
	public Long getCount(String name) {
		String hql = "SELECT count(p) FROM Product p WHERE p.name LIKE :name";
		return (Long) getSession().createQuery(hql)
			.setString("name", "%"+ name +"%")
			.uniqueResult();
	}

	@Override
	public List<Product> queryByCid(int cid) {
		String hql = "FROM Product p JOIN FETCH p.category WHERE p.category.id=:cid";
		return getSession().createQuery(hql).setInteger("cid", cid)
				.setFirstResult(0)
				.setMaxResults(4)
				.list();
	}
	
	@Override
	public List<Product> queryAllPro(int cid) {
		String hql = "FROM Product p JOIN FETCH p.category WHERE p.commend=true AND p.open=true AND p.category.id=:cid ORDER BY p.date DESC";
		return getSession().createQuery(hql)
				.setInteger("cid", cid)
				.list();
	}
	
	@Override
	public List<Product> getProName(String proname) {
		String hql = "SELECT p.name FROM Product p WHERE p.name LIKE :name ORDER BY p.id ASC";
		return getSession().createQuery(hql)
				.setString("name", "%"+proname+"%")
				.list();
	}
}
