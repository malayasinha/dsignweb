package com.tsky.dsign.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="profile")
public class ProfileEntity {
	
	@Id
	@Column(name="profile_id", length=50, nullable = false)
	private String profileId;
	
	@Column(name="profile_name", length=25, nullable=false)
	private String profileName;
	
	@Column(name="document_type", length=55, nullable = false)
	private String documentType;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "signatory1", referencedColumnName = "signatory_id")
	private SignatoryEntity signatory1;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "signatory2", referencedColumnName = "signatory_id")
	private SignatoryEntity signatory2;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "signatory3", referencedColumnName = "signatory_id")
	private SignatoryEntity signatory3;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "signatory4", referencedColumnName = "signatory_id")
	private SignatoryEntity signatory4;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "signatory5", referencedColumnName = "signatory_id")
	private SignatoryEntity signatory5;

	@Column(name="is_active")
	private Boolean isActive;
	
	@Column(name="created_by", length = 15, nullable = false)
	private String createdBy; 
	
	@Column(name="created_on", nullable = false)
	private Timestamp createdOn; 
	
	@Column(name="updated_by", length = 15)
	private String updatedBy;
	
	@Column(name="updated_on")
	private Timestamp updatedOn;

	
	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public SignatoryEntity getSignatory1() {
		return signatory1;
	}

	public void setSignatory1(SignatoryEntity signatory1) {
		this.signatory1 = signatory1;
	}

	public SignatoryEntity getSignatory2() {
		return signatory2;
	}

	public void setSignatory2(SignatoryEntity signatory2) {
		this.signatory2 = signatory2;
	}

	public SignatoryEntity getSignatory3() {
		return signatory3;
	}

	public void setSignatory3(SignatoryEntity signatory3) {
		this.signatory3 = signatory3;
	}

	public SignatoryEntity getSignatory4() {
		return signatory4;
	}

	public void setSignatory4(SignatoryEntity signatory4) {
		this.signatory4 = signatory4;
	}

	public SignatoryEntity getSignatory5() {
		return signatory5;
	}

	public void setSignatory5(SignatoryEntity signatory5) {
		this.signatory5 = signatory5;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ProfileEntity [profileId=" + profileId + ", profileName=" + profileName + ", documentType="
				+ documentType + ", signatory1=" + signatory1 + ", signatory2=" + signatory2 + ", signatory3="
				+ signatory3 + ", signatory4=" + signatory4 + ", signatory5=" + signatory5 + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", modifiedBy=" + updatedBy + ", modifiedOn=" + updatedOn + "]";
	} 
	
}
