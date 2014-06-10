package com.picsauditing.service.security.impl;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.service.security.SecurityService;
import com.picsauditing.service.user.UserContextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
@Service
public class SecurityServiceImpl implements SecurityService {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserContextService userContextService;

	@Autowired
	ShaPasswordEncoder shaPasswordEncoder;

	@Override
	public String encodePassword(String password){
		log.trace("entered SecurityServiceImpl.encodePassword()");
		return encodePassword(password,userContextService.getCurrentUserName());
	}

	@Override
	public String encodePassword(String password, String username) {
		log.trace("entered SecurityServiceImpl.encodePassword({})",username);
		return shaPasswordEncoder.encodePassword(password, username);
	}
}
