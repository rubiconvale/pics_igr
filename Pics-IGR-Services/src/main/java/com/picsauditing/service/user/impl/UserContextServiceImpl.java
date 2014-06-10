package com.picsauditing.service.user.impl;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.data.security.model.User;
import com.picsauditing.data.security.model.UserInformation;
import com.picsauditing.service.user.UserContextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
public class UserContextServiceImpl implements UserContextService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SecurityContext securityContext;

	public void setSecurityContext(SecurityContext securityContext){
		this.securityContext = securityContext;
	}

	@Override
	public boolean isAdmin() {
		boolean hasRole = false;

		for(GrantedAuthority auth: getCurrentUser().getAuthorities()){
			if(auth.getAuthority().equals("ROLE_ADMIN")){
				hasRole = true;
				break;
			}
		}
		return hasRole;
	}

	@Override
	public boolean isAuthor() {
		boolean hasRole = false;

		for(GrantedAuthority auth: getCurrentUser().getAuthorities()){
			if(auth.getAuthority().equals("ROLE_AUTHOR")){
				hasRole = true;
				break;
			}
		}
		return hasRole;
	}

	@Override
	public boolean isAgencyUser() {
		boolean hasRole = false;

		for(GrantedAuthority auth: getCurrentUser().getAuthorities()){
			if(auth.getAuthority().equals("ROLE_AGENCY_USER")){
				hasRole = true;
				break;
			}
		}
		return hasRole;
	}

	@Override
	public boolean isAgencyAdmin() {
		boolean hasRole = false;

		for(GrantedAuthority auth: getCurrentUser().getAuthorities()){
			if(auth.getAuthority().equals("ROLE_AGENCY_ADMIN")){
				hasRole = true;
				break;
			}
		}
		return hasRole;
	}

	@Override
	public boolean isAuthorizedToEdit(Object obj){
		boolean isAuthorized = false;

		for(GrantedAuthority auth: getCurrentUser().getAuthorities()){
			if(auth.getAuthority().equals("ROLE_ADMIN")){
				isAuthorized = true;
				break;
			}
		}
		return isAuthorized;
	}

	@Override
	public Long getCurrentUserId() {
		log.trace("entered UserContextServiceImpl.getCurrentUserId()");
		return getCurrentUser().getUserId();
	}

	@Override
	public String getCurrentUserName() {
		log.trace("entered UserContextServiceImpl.getCurrentUserName()");
		return getCurrentUser().getUsername();
	}

	@Override
	public User getCurrentUser() {
		log.trace("entered UserContextServiceImpl.getCurrentUser()");
//		return (User)SecurityContextHolder.getContext().getAuthentication();
//        UserInformation user = (UserInformation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (UserInformation)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
