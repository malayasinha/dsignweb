package com.tsky.dsign.service;

import java.util.Map;

import com.tsky.dsign.bean.ResponseBean;

public interface ModuleService {
	public ResponseBean<Map<String,String>> getSignedHistoryList(String module, String fileName);
	
	public ResponseBean<Map<String,String>> getSignedHistoryList(String module, String fromDate , String toDate);
	
	public void executeCommand(String module);
	
}
