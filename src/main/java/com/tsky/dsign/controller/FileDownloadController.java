package com.tsky.dsign.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	static Logger logger = LogManager.getLogger(FileDownloadController.class);
//	//{fileName:.+}
	@RequestMapping("/download1")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("filePath") String fileName) {
		logger.info("Download file called...");
		String dataDirectory = com.tsky.dsign.utility.Constants.FILEDIR;
		//Path file = Paths.get(dataDirectory, fileName);
		Path path = Paths.get("C:\\Users\\malaya\\Desktop\\TataskyBB\\processed", "DelayConfig.xlsx");
		logger.info("isExist : "+Files.exists(path));
		if (Files.exists(path)) {
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			//response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			try {
				Files.copy(path, response.getOutputStream());
				//response.getOutputStream().flush();
				response.flushBuffer();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
}