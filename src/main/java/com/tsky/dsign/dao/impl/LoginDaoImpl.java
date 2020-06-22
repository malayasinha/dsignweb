package com.tsky.dsign.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsky.dsign.dao.LoginDao;
import com.tsky.dsign.entity.UserEntity;

@Repository
public class LoginDaoImpl implements LoginDao {
	static Logger logger = LogManager.getLogger(LoginDao.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session getSession() {
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		return session;
	}
	
	@Override
	public UserEntity getLoginDetail(String userId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(UserEntity.class);
		crit.add(Restrictions.eq("userId",userId));
		UserEntity bean = (UserEntity) crit.uniqueResult();
		logger.info(bean);
		return bean;
	}

/*	@Override
	public UserBean getLoginDetail(String userId) {
		UserBean bean = new UserBean();
		bean.setUserId("admin");
		bean.setPassword("admin@123");
		bean.setIsActive(true);
		
		return bean;
	}
*/	
}
