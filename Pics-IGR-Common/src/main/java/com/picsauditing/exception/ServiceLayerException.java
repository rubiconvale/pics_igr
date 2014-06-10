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
public class ServiceLayerException extends ServiceUnexpectedException {	


	private static final long serialVersionUID = -8512570931719140110L;

	static Logger log=LoggerFactory.getLogger(ServiceLayerException.class);

	
	public static final String PICS_RUNTIME_UNHANDLED_SERVICE_FAULT="ServiceRuntimeFault";
	
	// VALIDATION EXCEPTION
	public static final String PICS_REQUIRED_ATTRIBUTES_MISSING_IN_REQUEST_ERROR="RequiredAttributesMissing";

	//Security Exception

	public static final String PICS_INVALID_ACCESS_SERVICE_ERROR="InvalidAccessError";
	
	// thrown for an illegal request.
	public static final String PICS_INVALID_SERVICE_REQUEST="InvalidServiceRequest";
	
	// errors thrown by rest services.  
	public static final String PICS_REST_SERVICE_XXX_FAILED = "RestServiceXXXFailed";	

	//Service Layer Transaction Error
	public static final String PICS_SERVICE_OPTIMISTIC_LOCK_FAILURE="ServiceOptimisticLockFailure";
	
	//Rest service invalid response
	public static final String PICS_SOURCESYSTEM_INVALID_RESPONSE= "RestServiceInvalidSystemResponse";
	
	//Business objects Error
	public static final String PICS_BUSINESS_ENTITY_NOTFOUND = "BusinessEntityNotFoundInTheSystem";
	
	
	// ADAPTOR EXCEPTION
	public static final String PICS_ADAPTOR_JAVAOBJECT_2_XML_JAXB_UTIL_EXCEPTION = "Java2XMLConvertionException";
	public static final String PICS_ADAPTOR_XML_2_JAVAOBJECT_JAXB_UTIL_EXCEPTION = "XML2JavaConvertionException";	
	
	public static final String PICS_SYSTEM_SRVICE_NOT_AVAILABLE = "ServiceNotAvailable";

	public static final String PICS_REST_SERVICE_NOT_SUPPORTED="RestServiceNotSupported";




	public ServiceLayerException(String errorCode) {
		super(errorCode);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceLayerException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceLayerException(String errorCode, Throwable originalCauseException) {
		super(errorCode, originalCauseException);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceLayerException(String errorCode, String errorMessage,
			String objectClass) {
		super(errorCode, errorMessage, objectClass);
		// TODO Auto-generated constructor stub
	}
	public ServiceLayerException(String errorCode, String errorMessage,
			String objectClass, Throwable originalCauseException) {
		super(errorCode, errorMessage, objectClass, originalCauseException);
		// TODO Auto-generated constructor stub
	}
	public ServiceLayerException(String errorCode, String errorMessage,
			Throwable originalCauseException) {
		super(errorCode, errorMessage, originalCauseException);
		// TODO Auto-generated constructor stub		
	}
	
	public boolean equals(String errorCode){
		return (getErrorCode()!=null && errorCode!=null)? getErrorCode().equalsIgnoreCase(errorCode) : false; 
	}
	
@Override
protected void log() {
	log.error(this.toString(), this);
}
}