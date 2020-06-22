package com.tsky.dsign.entity;

public class SignHistoryBean {
	private Long rowId;
	private String fileName;
	private String signer;
	private String status;
	private String failureReason;
	private String signedDate;
		
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSigner() {
		return signer;
	}
	public void setSigner(String signer) {
		this.signer = signer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSignedDate() {
		return signedDate;
	}
	public void setSignedDate(String signedDate) {
		this.signedDate = signedDate;
	}
	
	public String getFailureReason() {
		return failureReason;
	}
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
	@Override
	public String toString() {
		return "SignHistoryBean [rowId=" + rowId + ", fileName=" + fileName + ", signer=" + signer + ", status="
				+ status + ", signedDate=" + signedDate + "]";
	}
	
	public String fileHeader() {
		return "File Name,Signed By, Status, Failure Reason,Date \n";
	}
	
	public String fileBody() {
		return this.fileName +","+ this.signer+","+ this.status+","+ this.failureReason+","+this.signedDate +"\n";
	}
}
