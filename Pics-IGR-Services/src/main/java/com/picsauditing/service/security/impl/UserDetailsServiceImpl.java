package com.picsauditing.service.security.impl;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.data.security.model.User;
import com.picsauditing.service.security.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecurityService securityService;

//	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		log.trace("entered UserDetailsServiceImpl.loadUserByUsername({}) for security verification",username);
        return null;
	}
	
	public boolean isAdminUser() {
		boolean hasRole = false;

		for(GrantedAuthority auth: getCurrentUser().getAuthorities()){
			if(auth.getAuthority().equals("ROLE_ADMIN_USER")){
				hasRole = true;
				break;
			}
		}
		return hasRole;
	}
}
