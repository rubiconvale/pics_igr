package com.picsauditing.exception;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

/**
 * Created by RNatarajan on 6/4/2014.
 * Modification Log :
 */
public abstract class ServiceUnexpectedException extends RuntimeException {

	private static final long serialVersionUID = -6884731030368116616L;
	private String errorCode;
	private String errorMessage;
	private String objectClass;
	private Throwable originalCauseException;
	
	public ServiceUnexpectedException(String errorCode) {
		super();
		this.errorCode = errorCode;
		log();
	}
	
	public ServiceUnexpectedException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		log();
	}
	public ServiceUnexpectedException(String errorCode,Throwable originalCauseException) {
		super();
		this.errorCode = errorCode;
		if(originalCauseException!=null)
		this.errorMessage = originalCauseException.getLocalizedMessage();
		this.originalCauseException = originalCauseException;
		log();
	}
	public ServiceUnexpectedException(String errorCode, String errorMessage,String objectClass) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.objectClass = objectClass;
		log();
	}
	public ServiceUnexpectedException(String errorCode, String errorMessage,String objectClass, Throwable originalCauseException) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.objectClass = objectClass;
		this.originalCauseException = originalCauseException;
		log();
	}
	public ServiceUnexpectedException(String errorCode, String errorMessage,Throwable originalCauseException) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.originalCauseException = originalCauseException;
		log();
	}	
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getObjectClass() {
		return objectClass;
	}
	public Throwable getOriginalCauseException() {
		return originalCauseException;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}
	public void setOriginalCauseException(Throwable originalCauseException) {
		this.originalCauseException = originalCauseException;
	}
	protected abstract void log();
	
	
	public String getUnifiedShortFaultInfo() {
		StringBuffer buf = new StringBuffer();		
		buf.append(getErrorCode());		
		if(getErrorMessage()!=null)			
			buf.append("{").append(getErrorMessage()).append("}");		
		return buf.toString();			
	}
	

	public String getOriginalFaultInfo() {
		StringBuffer buf = new StringBuffer();		
		if(getOriginalCauseException()!=null){
			buf.append("OriginalException:").append(getOriginalCauseException().getMessage()).append("\n");
		}
		
		return buf.toString();			
	}
	
	public String toString() {

		StringBuffer buf = new StringBuffer();
		buf.append("**** ServiceUnexpectedException ********").append("\n");
		buf.append("Thread Id\t\t:"); buf.append(Thread.currentThread().toString()).append("\n");
		buf.append("Error Code\t\t:"); buf.append(getErrorCode()).append("\n");
		
		if(getErrorMessage()!=null)			
			buf.append("Error Message\t\t:").append(getErrorMessage()).append("\n");
		
		if(getObjectClass()!=null)	
			buf.append("Object Class\t\t:").append(getObjectClass()).append("\n");
			
		if(getOriginalCauseException()!=null)
			buf.append("OriginalException\t\t:").append(getOriginalCauseException().getMessage()).append("\n");


		return buf.toString();	
		
	}
}
