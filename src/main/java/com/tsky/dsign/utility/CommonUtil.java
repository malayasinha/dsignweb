package com.tsky.dsign.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.tsky.dsign.bean.MailHistoryBean;
import com.tsky.dsign.bean.SignHistoryBean;

public class CommonUtil {
	public static String HOUR = "HOUR";
	public static String MINUTE = "MIN";
	public static String SECOND = "SEC";
	public static String DAY = "DAY";

	public static boolean isNull(String str) {
		if (str == null || str.equalsIgnoreCase("NULL") || str.equalsIgnoreCase("")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNull(java.sql.Date str) {
		if (str == null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNull(Integer str) {
		if (str == null) {
			return true;
		} else {
			return false;
		}
	}

	public static String replaceNull(String str) {
		if (str == null || str.equalsIgnoreCase("NULL") || str.equalsIgnoreCase("")) {
			return "";
		} else {
			return str;
		}
	}

	public static Double replaceNull(Double str) {
		if (str == null) {
			return 0.00;
		} else {
			return str;
		}
	}

	public static Integer replaceNull(Integer str) {
		if (str == null) {
			return 0;
		} else {
			return str;
		}
	}
	public static String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm");  
	    Date date = new Date();  
	    return formatter.format(date);
	}
	public static Double timestampdiff(Timestamp startTime, Timestamp endTime, String type) {

		HashMap<String, Integer> timeMap = new HashMap<String, Integer>();
		timeMap.put("SEC", 1);
		timeMap.put("MIN", 2);
		timeMap.put("HOUR", 3);
		timeMap.put("DAY", 4);

		Long milliseconds1 = startTime.getTime();
		Long milliseconds2 = endTime.getTime();

		Long diff = milliseconds2 - milliseconds1;
		Double doubleVal = 0.0;
		switch (timeMap.get(type)) {
		case 1:
			doubleVal = Double.parseDouble(diff.toString()) / 1000;
			break;
		case 2:
			doubleVal = Double.parseDouble(diff.toString()) / (60 * 1000);
			break;
		case 3:
			doubleVal = Double.parseDouble(diff.toString()) / (60 * 60 * 1000);
			break;
		case 4:
			doubleVal = Double.parseDouble(diff.toString()) / (24 * 60 * 60 * 1000);
			break;

		default:
			doubleVal = Double.parseDouble(diff.toString());
		}

		return doubleVal;

	}

	public static Double timestampdiff(String startTime, String endTime, String type) {
		Timestamp st = Timestamp.valueOf(startTime);
		Timestamp et = Timestamp.valueOf(endTime);

		HashMap<String, Integer> timeMap = new HashMap<String, Integer>();
		timeMap.put("SEC", 1);
		timeMap.put("MIN", 2);
		timeMap.put("HOUR", 3);
		timeMap.put("DAY", 4);

		Long milliseconds1 = st.getTime();
		Long milliseconds2 = et.getTime();

		Long diff = milliseconds2 - milliseconds1;
		Double doubleVal = 0.0;
		switch (timeMap.get(type)) {
		case 1:
			doubleVal = Double.parseDouble(diff.toString()) / 1000;
			break;
		case 2:
			doubleVal = Double.parseDouble(diff.toString()) / (60 * 1000);
			break;
		case 3:
			doubleVal = Double.parseDouble(diff.toString()) / (60 * 60 * 1000);
			break;
		case 4:
			doubleVal = Double.parseDouble(diff.toString()) / (24 * 60 * 60 * 1000);
			break;

		default:
			doubleVal = Double.parseDouble(diff.toString());
		}

		return doubleVal;

	}

	public static String convertToFormat(String srcStr, String srcPattern, String dstPattern) {
		DateFormat srcDf = new SimpleDateFormat(srcPattern);
		// parse the date string into Date object
		Date date = null;
		try {
			date = srcDf.parse(srcStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		DateFormat destDf = new SimpleDateFormat(dstPattern);

		// format the date into another format
		String dstStr = destDf.format(date);
		
		return dstStr;
	}
	public static Calendar convertToCalendar(String srcStr, String srcPattern) {
		DateFormat srcDf = new SimpleDateFormat(srcPattern);
		// parse the date string into Date object
		Date date = null;
		try {
			date = srcDf.parse(srcStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		return cal;		
	}
	public static String getLastDayOfPreviousMonth() {
		Calendar aCalendar = Calendar.getInstance();
		// add -1 month to current month
		aCalendar.add(Calendar.MONTH, -1);
		// set DATE to 1, so first date of previous month
		aCalendar.set(Calendar.DATE, 1);

		Date firstDateOfPreviousMonth = aCalendar.getTime();

		// set actual maximum date of previous month
		aCalendar.set(Calendar.DATE, aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		// read it
		Date lastDateOfPreviousMonth = aCalendar.getTime();

		String newDate = new SimpleDateFormat("yyyy-MM-dd").format(lastDateOfPreviousMonth);

		return newDate;
	}

	public static String saveFile(InputStream inputStream, String location) {
		OutputStream outStream = null;
		try {
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);

			File targetFile = new File(location);
			outStream = new FileOutputStream(targetFile);
			outStream.write(buffer);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return location;
	}
	
	public static String writeUsingBufferedWriter(List<SignHistoryBean> signList) {
		String searchFileLoc = ResourceReader.readConfigProps("file.location.search");
		String fileName = randomAlphaNumeric(16)+".csv";
		File file = new File(searchFileLoc+"/"+fileName);
        FileWriter fr = null;
        BufferedWriter br = null;
        
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            br.write(signList.get(0).fileHeader());
            for(SignHistoryBean bean:signList){
                br.write(bean.fileBody());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
	
	public static String writeUsingBufferedWriter2(List<MailHistoryBean> mailList) {
		String searchFileLoc = ResourceReader.readConfigProps("file.location.search");
		String fileName = randomAlphaNumeric(16)+".csv";
		File file = new File(searchFileLoc+"/"+fileName);
        FileWriter fr = null;
        BufferedWriter br = null;
        
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            br.write(mailList.get(0).fileHeader());
            for(MailHistoryBean bean:mailList){
                br.write(bean.fileBody());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
	
	public static String randomAlphaNumeric(int count) {
		String ALPHA_NUMERIC_STRING = ResourceReader.readConfigProps("randomtext.salt");
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
