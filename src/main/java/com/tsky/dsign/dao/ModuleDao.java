package com.tsky.dsign.dao;

import java.sql.Timestamp;
import java.util.List;

import com.tsky.dsign.entity.MailHistoryBean;
import com.tsky.dsign.entity.SignHistoryBean;

public interface ModuleDao {
	
	public List<SignHistoryBean> getSignHistory(String module, String fileName);
	public List<SignHistoryBean> getSignHistory(String module, Timestamp fromDate,Timestamp toDate);
	
	public List<MailHistoryBean> getMailHistory(String module, String fileName);
	public List<MailHistoryBean> getMailHistory(String module, Timestamp fromDate,Timestamp toDate);
}
