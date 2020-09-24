package com.tsky.dsign.repository;

import com.tsky.dsign.entity.SignatoryEntity;

public interface SignatoryRepository{
	
	public SignatoryEntity get(String signatoryId);
	public SignatoryEntity save(SignatoryEntity signatory);
	
	
}
