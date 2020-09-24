package com.tsky.dsign.bean;

public class ResponseBean<T> {
	private String message;
	private T object;
	private Boolean hasError;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	public Boolean getHasError() {
		return hasError;
	}
	public void setHasError(Boolean hasError) {
		this.hasError = hasError;
	}
	@Override
	public String toString() {
		return "ResponseObject [message=" + message + ", object=" + object + ", hasError=" + hasError + "]";
	}
	public ResponseBean(String message, T object, Boolean hasError) {
		super();
		this.message = message;
		this.object = object;
		this.hasError = hasError;
	}
	public ResponseBean() {
		super();
		
	}
	
}
