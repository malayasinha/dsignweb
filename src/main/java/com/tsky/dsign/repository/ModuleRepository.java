package com.tsky.dsign.repository;

import java.sql.Timestamp;
import java.util.List;

import com.tsky.dsign.bean.MailHistoryBean;
import com.tsky.dsign.bean.SignHistoryBean;

public interface ModuleRepository {
	
	public List<SignHistoryBean> getSignHistory(String module, String fileName);
	public List<SignHistoryBean> getSignHistory(String module, Timestamp fromDate,Timestamp toDate);
	
	public List<MailHistoryBean> getMailHistory(String module, String fileName);
	public List<MailHistoryBean> getMailHistory(String module, Timestamp fromDate,Timestamp toDate);
}
