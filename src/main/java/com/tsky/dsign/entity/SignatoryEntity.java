package com.tsky.dsign.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="signatories")
public class SignatoryEntity {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="signatory_id", length=15 ,nullable = false)
	private String signatoryId; 
	
	@Column(name="name", length = 50, nullable = false)
	private String signatoryName;
	
	@Column(name="private_key", length = 50, nullable = false)
	private String signaturePrivateKey;
	
	@Column(name="certificate_key", length = 50, nullable = false)
	private String signatureCertificateKey; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employee_id", referencedColumnName = "employee_id")
	private EmployeeEntity employee; 
	
	@Column(name="start_date")
	private Date startDate; 
	
	@Column(name="end_date")
	private Date endDate; 
	
	@Column(name="is_active", nullable = false)
	private Boolean isActive;
	
	@Column(name="created_by", length = 15)
	private String createdBy; 
	
	@Column(name="created_on")
	private Timestamp createdOn; 
	
	@Column(name="updated_by", length = 15)
	private String updatedBy;
	
	@Column(name="updated_on")
	private Timestamp updatedOn;

	
	
	public SignatoryEntity() {
		super();
	}

	public SignatoryEntity(String signatoryId) {
		super();
		this.signatoryId = signatoryId;
	}

	public String getSignatoryId() {
		return signatoryId;
	}

	public void setSignatoryId(String signatoryId) {
		this.signatoryId = signatoryId;
	}

	public String getSignatoryName() {
		return signatoryName;
	}

	public void setSignatoryName(String signatoryName) {
		this.signatoryName = signatoryName;
	}

	public String getSignaturePrivateKey() {
		return signaturePrivateKey;
	}

	public void setSignaturePrivateKey(String signaturePrivateKey) {
		this.signaturePrivateKey = signaturePrivateKey;
	}

	public String getSignatureCertificateKey() {
		return signatureCertificateKey;
	}

	public void setSignatureCertificateKey(String signatureCertificateKey) {
		this.signatureCertificateKey = signatureCertificateKey;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "SignatoryEntity [signatoryId=" + signatoryId + ", signatoryName=" + signatoryName
				+ ", signaturePrivateKey=" + signaturePrivateKey + ", signatureCertificateKey="
				+ signatureCertificateKey + ", employee=" + employee + ", startDate=" + startDate + ", endDate="
				+ endDate + ", isActive=" + isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}

	
}
