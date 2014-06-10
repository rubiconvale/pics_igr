/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */



package com.picsauditing.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
/**
 * Created by RNatarajan on 6/4/2014.
 * Modification Log :
 */
@Aspect
@Component
public class LoggingAspect extends SystemAop{
 Logger log=LoggerFactory.getLogger(this.getClass());

@Pointcut("inServiceEndpoint() && args(modelMap,..)")
public void endpointMethods(ModelMap modelMap){};

@Pointcut("execution(* get*(..))")
public void xdbMethods(){};

	@Around("inDataAccessLayer() && dataAccessOperation() && xdbMethods()")
	public Object interceptXdbExecution(ProceedingJoinPoint pjp) throws Throwable{

		String op = pjp.getTarget().getClass().getSimpleName()+"."+pjp.getSignature().getName();	
		log.info(TRACE_TEMPLATE, new Object[]{op, STATE_REQUEST_RECEIVED, STATUS_INITIATING ,0});
		long startTime = System.currentTimeMillis();
		Object output;
		try{				
		output = pjp.proceed();
		log.info(TRACE_TEMPLATE, new Object[]{op, STATE_RESPONSE_BEING_SENT, STATUS_SUCCESSFUL ,(System.currentTimeMillis()-startTime)});		
		}catch (Throwable e) {
			log.info(TRACE_TEMPLATE, new Object[]{op, STATE_RESPONSE_BEING_SENT, STATUS_FAILED ,(System.currentTimeMillis()-startTime)});
			throw e;
		}
		return output;
	}

	@Around("endpointMethods(modelMap)")
	public Object interceptServiceEndPointExecution(ProceedingJoinPoint pjp, ModelMap modelMap) throws Throwable{

		String op = pjp.getTarget().getClass().getSimpleName()+"."+pjp.getSignature().getName();	
		log.info(TRACE_TEMPLATE, new Object[]{op, STATE_REQUEST_RECEIVED, STATUS_INITIATING ,0});
		long startTime = System.currentTimeMillis();
		Object output;
		try{				
		output = pjp.proceed();
		log.info(TRACE_TEMPLATE, new Object[]{op, STATE_RESPONSE_BEING_SENT, STATUS_SUCCESSFUL ,(System.currentTimeMillis()-startTime)});		
		}catch (Throwable e) {
			log.info(TRACE_TEMPLATE, new Object[]{op, STATE_RESPONSE_BEING_SENT, STATUS_FAILED ,(System.currentTimeMillis()-startTime)});
			throw e;
		}
		return output;
	}

	@Around("inServiceLayer() && businessServiceOperation()")
	public Object interceptServiceExecution(ProceedingJoinPoint pjp) throws Throwable{

		String op = pjp.getTarget().getClass().getSimpleName()+"."+pjp.getSignature().getName();	
		log.info(TRACE_TEMPLATE, new Object[]{op, STATE_REQUEST_RECEIVED, STATUS_INITIATING ,0});
		long startTime = System.currentTimeMillis();
		Object output;
		try{				
		output = pjp.proceed();
		log.info(TRACE_TEMPLATE, new Object[]{op, STATE_RESPONSE_BEING_SENT, STATUS_SUCCESSFUL ,(System.currentTimeMillis()-startTime)});		
		}catch (Throwable e) {
			log.info(TRACE_TEMPLATE, new Object[]{op, STATE_RESPONSE_BEING_SENT, STATUS_FAILED ,(System.currentTimeMillis()-startTime)});
			throw e;
		}
		return output;
	}
}
