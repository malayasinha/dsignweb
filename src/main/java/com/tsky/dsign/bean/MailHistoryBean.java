package com.tsky.dsign.bean;

public class MailHistoryBean {
	private String fileName;
	private String mailId;
	private String status;
	private String date;
	
	public MailHistoryBean(String fileName, String mailId, String status, String date) {
		super();
		this.fileName = fileName;
		this.mailId = mailId;
		this.status = status;
		this.date = date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MailHistoryBean [fileName=" + fileName + ", mailId=" + mailId + ", status=" + status + ", date=" + date
				+ "]";
	}

	public MailHistoryBean() {
		super();
	}
	
	public String fileHeader() {
		return "File Name,Mail ID,Status,Date \n";
	}
	
	public String fileBody() {
		return this.fileName +","+ this.mailId+","+ this.status+","+ this.date +"\n";
	}
	
}
