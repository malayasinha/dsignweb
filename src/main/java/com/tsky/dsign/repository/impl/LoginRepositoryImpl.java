package com.tsky.dsign.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tsky.dsign.entity.UserEntity;
import com.tsky.dsign.repository.LoginRepository;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
	static Logger logger = LogManager.getLogger(LoginRepository.class);
	
	/*
	 * @Autowired SessionFactory sessionFactory;
	 * 
	 * Session getSession() { Session session; try { session =
	 * sessionFactory.getCurrentSession(); } catch (HibernateException e) { session
	 * = sessionFactory.openSession(); } return session; }
	 */
	@PersistenceContext
	EntityManager em;
	
	@Override
	public UserEntity getLoginDetail(String userId) {
		UserEntity response = (UserEntity) em.find(UserEntity.class, userId);
		return response;
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
