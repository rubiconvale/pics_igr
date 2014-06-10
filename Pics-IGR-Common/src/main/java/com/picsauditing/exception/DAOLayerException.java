
package com.picsauditing.exception;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by RNatarajan on 6/4/2014.
 * Modification Log :
 */
public class DAOLayerException extends ServiceUnexpectedException {

	// PICS Persistance Error
	public static final String PICS_DOMAIN_OBJECT_DATA_PERSISTANCE_FAILED="FailedToPersistPICSDomainObject";
	public static final String PICS_DOMAIN_OBJECT_DATA_RETRIEVAL_FAILED="ErrorRetrievingPICSDomainObject";

	
	static Logger log=LoggerFactory.getLogger(DAOLayerException.class);
	public DAOLayerException(String errorCode) {
		super(errorCode);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void log() {
		log.error(this.toString(), this);
		
	}
	public DAOLayerException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
	
	public DAOLayerException(String errorCode, Throwable originalCauseException) {
		super(errorCode, originalCauseException);
		// TODO Auto-generated constructor stub
	}
	
	public DAOLayerException(String errorCode, String errorMessage,
			String objectClass) {
		super(errorCode, errorMessage, objectClass);
		// TODO Auto-generated constructor stub
	}
	public DAOLayerException(String errorCode, String errorMessage,
			String objectClass, Throwable originalCauseException) {
		super(errorCode, errorMessage, objectClass, originalCauseException);
		// TODO Auto-generated constructor stub
	}
	public DAOLayerException(String errorCode, String errorMessage,
			Throwable originalCauseException) {
		super(errorCode, errorMessage, originalCauseException);
		// TODO Auto-generated constructor stub		
	}
	
	public boolean equals(String errorCode){
		return (getErrorCode()!=null && errorCode!=null)? getErrorCode().equalsIgnoreCase(errorCode) : false; 
	}

}
