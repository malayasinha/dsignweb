package com.tsky.dsign.dto;

public class ResponseObject<T> {
	private String message;
	private T data;
	private Boolean hasError;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Boolean getHasError() {
		return hasError;
	}
	public void setHasError(Boolean hasError) {
		this.hasError = hasError;
	}
	@Override
	public String toString() {
		return "ResponseObject [message=" + message + ", data=" + data + ", hasError=" + hasError + "]";
	}
	public ResponseObject(String message, T data, Boolean hasError) {
		super();
		this.message = message;
		this.data = data;
		this.hasError = hasError;
	}
	public ResponseObject() {
		super();
		
	}
	
}
