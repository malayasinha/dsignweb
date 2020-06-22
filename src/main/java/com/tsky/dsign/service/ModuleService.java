package com.tsky.dsign.service;

import java.util.Map;

import com.tsky.dsign.dto.ResponseObject;

public interface ModuleService {
	public ResponseObject<Map<String,String>> getSignedHistoryList(String module, String fileName);
	
	public ResponseObject<Map<String,String>> getSignedHistoryList(String module, String fromDate , String toDate);
	
	public void executeCommand(String module);
	
}
