package com.tsky.dsign.repository.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.tsky.dsign.repository.ModuleRepository;

@Repository
public class ModuleRepositoryImpl implements ModuleRepository {
	static Logger logger = LogManager.getLogger(ModuleRepository.class);
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<SignHistoryBean> getSignHistory(String module, String fileName) {
		logger.info("Repository called for "+module);
		String sql = "Select * from "+module+".sign_history where sign_document_name like :file";
		//String sql = "Select * from dsigndb.sign_history where sign_document_name like '%File19940.pdf'";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("file", "%"+fileName+"%");
		
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,parameters);
        
        List<SignHistoryBean> list = new ArrayList<SignHistoryBean>();
        SignHistoryBean bean = null;
        Timestamp timestamp = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        
        for (Map row : rows) {
        	bean = new SignHistoryBean();
        	bean.setRowId((Long)row.get("row_id"));
        	bean.setFileName((String)row.get("sign_document_name"));
        	//bean.setSignedDate(signedDate);
        	timestamp = (Timestamp)row.get("sign_date");
        	
        	bean.setSignedDate(formatter.format(timestamp));
        	bean.setSigner((String)row.get("signer_name"));
        	bean.setStatus((String)row.get("sign_status"));
        	bean.setFailureReason((String) row.get("failure_reason"));
        	list.add(bean);
        }
        return list;
	}
	
	@Override
	public List<SignHistoryBean> getSignHistory(String module, Timestamp fromDate, Timestamp toDate) {
		logger.info("dao report for "+module);
		String sql = "Select * from "+module+".sign_history where sign_date between :fromDate and :toDate ";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("fromDate", fromDate);
        parameters.addValue("toDate", toDate);
		
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,parameters);
        
        List<SignHistoryBean> list = new ArrayList<SignHistoryBean>();
        SignHistoryBean bean = null;
        Timestamp timestamp = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        
        for (Map row : rows) {
        	bean = new SignHistoryBean();
        	bean.setRowId((Long)row.get("row_id"));
        	bean.setFileName((String)row.get("sign_document_name"));
        	//bean.setSignedDate(signedDate);
        	timestamp = (Timestamp)row.get("sign_date");
        	
        	bean.setSignedDate(formatter.format(timestamp));
        	
        	bean.setSigner((String)row.get("signer_name"));
        	bean.setFailureReason((String) row.get("failure_reason"));
        	bean.setStatus((String)row.get("sign_status"));
        	list.add(bean);
        }
        return list;
	}


	@Override
	public List<MailHistoryBean> getMailHistory(String module, String fileName) {
		logger.info("Repository called for "+module);
		String sql = "Select * from "+module+".tbl_email_history where document_name like :file ";
		//String sql = "Select * from dsigndb.sign_history where sign_document_name like '%File19940.pdf'";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("file", "%"+fileName+"%");
		
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,parameters);
        
        List<MailHistoryBean> list = new ArrayList<MailHistoryBean>();
        MailHistoryBean bean = null;
        Timestamp timestamp = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        
        for (Map row : rows) {
        	bean = new MailHistoryBean();
        	
        	bean.setFileName((String)row.get("document_name"));
        	//bean.setSignedDate(signedDate);
        	timestamp = (Timestamp)row.get("send_date");
        	
        	bean.setDate(formatter.format(timestamp));
        	bean.setMailId((String)row.get("email_id"));
        	bean.setStatus((String)row.get("status"));
        	list.add(bean);
        }
        return list;
	}


	@Override
	public List<MailHistoryBean> getMailHistory(String module, Timestamp fromDate, Timestamp toDate) {
		logger.info("dao report for "+module);
		String sql = "Select * from "+module+".tbl_email_history where send_date between :fromDate and :toDate ";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("fromDate", fromDate);
        parameters.addValue("toDate", toDate);
		
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,parameters);
        
        List<MailHistoryBean> list = new ArrayList<MailHistoryBean>();
        MailHistoryBean bean = null;
        Timestamp timestamp = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        
        for (Map row : rows) {
        	bean = new MailHistoryBean();
        	
        	bean.setFileName((String)row.get("document_name"));
        	//bean.setSignedDate(signedDate);
        	timestamp = (Timestamp)row.get("send_date");
        	
        	bean.setDate(formatter.format(timestamp));
        	bean.setMailId((String)row.get("email_id"));
        	bean.setStatus((String)row.get("status"));
        	list.add(bean);
        }
        return list;
	}
	
}
