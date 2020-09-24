package com.tsky.dsign.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.tsky.dsign.bean.MailHistoryBean;
import com.tsky.dsign.bean.ResponseBean;
import com.tsky.dsign.bean.SignHistoryBean;
import com.tsky.dsign.repository.ModuleRepository;
import com.tsky.dsign.service.ModuleService;
import com.tsky.dsign.utility.CommonUtil;
import com.tsky.dsign.utility.ConnectToServer;

@Service
@PropertySource("classpath:messages_en.properties")
public class ModuleServiceImpl implements ModuleService {
	static Logger logger = LogManager.getLogger(ModuleServiceImpl.class);
	
	@Autowired
	Environment environment;
	
	@Autowired
	ModuleRepository tariffDao;
	
	@Override
	public ResponseBean<Map<String,String>> getSignedHistoryList(String module, String fileName) {
		ResponseBean<Map<String,String>> response = new ResponseBean<>(); 
		logger.info("Service called for "+module);
		List<SignHistoryBean> signList = new ArrayList<SignHistoryBean>();
		List<MailHistoryBean> mailList = new ArrayList<MailHistoryBean>();
		StringTokenizer tokens = new StringTokenizer(fileName,",");
		String token = "";
		String signFile,mailFile = "";
		Map<String,String> retMap = new HashMap<>();
		if(tokens.countTokens()>15) {
			response = new ResponseBean<>(environment.getRequiredProperty("message.data.tokenlimit"),null,true);
		} else {
			while(tokens.hasMoreTokens()) {
				token = tokens.nextToken().replaceAll("\\s", "");;
				signList.addAll(tariffDao.getSignHistory(module, token));
				if(module.equals("dsigndb2")) {
					mailList.addAll(tariffDao.getMailHistory(module, token));
				}
			}
			if(signList.size()>0) {
				signFile = CommonUtil.writeUsingBufferedWriter(signList);
				retMap.put("SIGN", signFile);
				if(module.equals("dsigndb2")  && mailList.size()>0) {
					mailFile = CommonUtil.writeUsingBufferedWriter2(mailList);
					retMap.put("MAIL", mailFile);
				}
				response = new ResponseBean<>(environment.getRequiredProperty("message.data.exist"),retMap,false);
			} else {
				response = new ResponseBean<>(environment.getRequiredProperty("message.data.no"),retMap,true);
			}
		}
		
		return response;
	}
	
	@Override
	public ResponseBean<Map<String,String>> getSignedHistoryList(String module, String fromDate, String toDate) {
		ResponseBean<Map<String,String>> response = new ResponseBean<>();
		logger.info("service for report:"+module);
		String pattern = "yyyy-MM-dd";
		Calendar fromCal = CommonUtil.convertToCalendar(fromDate, pattern);
		Calendar toCal = CommonUtil.convertToCalendar(toDate, pattern);
		fromCal.set(Calendar.HOUR,0);fromCal.set(Calendar.MINUTE, 0);fromCal.set(Calendar.SECOND, 0);fromCal.set(Calendar.MILLISECOND, 0);
		toCal.set(Calendar.HOUR,23);toCal.set(Calendar.MINUTE, 59);toCal.set(Calendar.SECOND, 59);toCal.set(Calendar.MILLISECOND, 999);
		
		List<SignHistoryBean> signList = new ArrayList<SignHistoryBean>();
		List<MailHistoryBean> mailList = new ArrayList<MailHistoryBean>();
		String signFile,mailFile = "";
		Map<String,String> retMap = new HashMap<>();
		logger.info(new Timestamp(fromCal.getTimeInMillis())+"   "+ new Timestamp(toCal.getTimeInMillis()));
		
		signList = tariffDao.getSignHistory(module, new Timestamp(fromCal.getTimeInMillis()), new Timestamp(toCal.getTimeInMillis()));
		if(module.equals("dsigndb2")) {
			mailList.addAll(tariffDao.getMailHistory(module, new Timestamp(fromCal.getTimeInMillis()), new Timestamp(toCal.getTimeInMillis())));
		}
		
		if(signList.size()>0) {
			signFile = CommonUtil.writeUsingBufferedWriter(signList);
			retMap.put("SIGN", signFile);
			logger.info("mail list size:"+mailList.size());
			if(module.equals("dsigndb2") && mailList.size()>0) {
				mailFile = CommonUtil.writeUsingBufferedWriter2(mailList);
				retMap.put("MAIL", mailFile);
			}
			response = new ResponseBean<>(environment.getRequiredProperty("message.data.exist"),retMap,false);
		} else {
			response = new ResponseBean<>(environment.getRequiredProperty("message.data.no"),retMap,true);
		}
		return response;
	}
	@Override
	public void executeCommand(String command) {
		logger.info("Executing command!!!");
		
		new ConnectToServer().Execute(command);
		
	}
}
