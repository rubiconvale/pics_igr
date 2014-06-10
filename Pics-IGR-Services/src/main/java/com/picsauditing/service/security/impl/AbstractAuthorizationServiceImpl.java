package com.picsauditing.service.security.impl;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.data.security.model.User;
import com.picsauditing.service.security.AuthorizationService;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */


public abstract class AbstractAuthorizationServiceImpl implements AuthorizationService {

	private User user;
	static{
		//user= (UserInformation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
		}
	@Override
	public User getSecurityContextHolder() {
		user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}

}
