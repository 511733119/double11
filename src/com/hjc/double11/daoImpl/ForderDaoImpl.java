package com.hjc.double11.daoImpl;

import org.springframework.stereotype.Repository;

import com.hjc.double11.dao.ForderDao;
import com.hjc.double11.model.Forder;

/*
 * 模块自身的业务逻辑
 */
@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements ForderDao {

}
