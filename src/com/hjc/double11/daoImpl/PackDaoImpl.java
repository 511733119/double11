package com.hjc.double11.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjc.double11.dao.PackDao;
import com.hjc.double11.dao.SorderDao;
import com.hjc.double11.model.Pack;
import com.hjc.double11.model.Sorder;

/*
 * 模块自身的业务逻辑
 */
@SuppressWarnings("unchecked")
@Repository("packDao")
public class PackDaoImpl extends BaseDaoImpl<Pack> implements PackDao {

	@Override
	public List<Pack> getPackList(int id) {
		return getSession().createQuery("from Pack where uid=:id").setInteger("id", id).list();
	}

	@Override
	public void deleteThePack(BigDecimal price,int uid) {
		String hql = "delete from pack where price=:price and uid=:uid limit 1";
		getSession().createSQLQuery(hql)
				.setBigDecimal("price", price)
				.setInteger("uid", uid)
				.executeUpdate();
	}
}
