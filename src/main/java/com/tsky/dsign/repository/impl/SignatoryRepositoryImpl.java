package com.tsky.dsign.repository.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tsky.dsign.bean.MailHistoryBean;
import com.tsky.dsign.bean.SignHistoryBean;
import com.tsky.dsign.entity.ProfileEntity;
import com.tsky.dsign.entity.SignatoryEntity;
import com.tsky.dsign.repository.ModuleRepository;
import com.tsky.dsign.repository.ProfileRepository;
import com.tsky.dsign.repository.SignatoryRepository;

@Repository
public class SignatoryRepositoryImpl implements SignatoryRepository  {
	static Logger logger = LogManager.getLogger(ModuleRepository.class);
		
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	EntityManager em;

	@Override
	public SignatoryEntity get(String signatoryId) {
		SignatoryEntity sig = (SignatoryEntity) em.find(SignatoryEntity.class, signatoryId);
		return sig;
	}

	@Override
	public SignatoryEntity save(SignatoryEntity signatory) {
		SignatoryEntity sig = em.merge(signatory);
		return sig;
	}

	
	
}
