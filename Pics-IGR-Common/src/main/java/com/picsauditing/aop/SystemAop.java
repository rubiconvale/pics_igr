

package com.picsauditing.aop;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
/**
 * Created by RNatarajan on 6/4/2014.
 * Modification Log :
 */


@Aspect
public abstract class SystemAop {
	public static final String STATE_REQUEST_RECEIVED = "REQUEST_RECEIVED";
	public static final String STATE_RESPONSE_BEING_SENT = "RESPONSE_BEING_SENT";	
	public static final String STATE_REQUEST_BEING_SENT = "REQUEST_BEING_SENT";
	public static final String STATE_RESPOSE_RECEIVED = "RESPONSE_RECEIVED";
	public static final String EVENT_REQUEST_BEING_PROCESSED = "IN_FLIGHT";
	
	public static final String STATUS_INITIATING = "INITIATING";
	public static final String STATUS_SUCCESSFUL = "SUCCESSFUL";
	public static final String STATUS_FAILED = "FAILED";
	public static final String BLANK = "";
	public static final String TRACE_TEMPLATE = "JoinPoint:{} - State:{} - Status:{} - Time(msec):{}";
	
	@Pointcut("within(com.com.web..*)")
	public  void inWebLayer() {
	}

	@Pointcut("within(com.com.web.kms.controller..*)")
	public void inServiceEndpoint() {
	}

	@Pointcut("within(com.com.service..*)")
	public void inServiceLayer() {
	}

	@Pointcut("within(com.com.data.kms.dao..*)")
	public void inDataAccessLayer() {
	}

	@Pointcut("execution(* com.com.service..*(..))")
	public void businessServiceOperation() {
	}

	@Pointcut("execution(* com.com.data.kms.dao..*(..))")
	public void dataAccessOperation() {
	}
}
