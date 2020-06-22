package com.tsky.dsign.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ResourceUtils;

public class ResourceReader {
	static Logger logger = LogManager.getLogger(ResourceReader.class);
	static Map<String, String> configMap = new HashMap<>();
	
	
	public static String readConfigProps(String key) {
		String configFile = Constants.CONFIGFILELOC;
		Properties props = new Properties();
		
		File file = null;
		InputStream inputStream = null;
		try {
			file = ResourceUtils.getFile(configFile);
			inputStream = new FileInputStream(file);
			props.load(inputStream);
		} catch (FileNotFoundException e1) {
		
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props.getProperty(key);
	}
}
