package com.picsauditing.service.security.impl;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.picsauditing.data.security.constants.SecurityStatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */

public class LoginFailureHandler implements AuthenticationFailureHandler {

    final Logger log = LoggerFactory.getLogger("org.springframework.security");

    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {

        ObjectMapper mapper = new ObjectMapper();
        SecurityStatus status = new SecurityStatus(null, false, false, null);

        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)e.getAuthentication();
        WebAuthenticationDetails details = (WebAuthenticationDetails)auth.getDetails();

        if(e instanceof AuthenticationServiceException){
            status.setSecurityStatusType(SecurityStatusType.AUTHENTICATION);
            log.error("Invalid username login attempt from [{}], using username [{}]",details.getRemoteAddress(), auth.getName());

        }else if(e instanceof BadCredentialsException){
            log.error("Invalid username/password login attempt for [{}], from [{}]",auth.getName(),details.getRemoteAddress());

            status.setUsername(auth.getName());
            status.setSecurityStatusType(SecurityStatusType.BADCREDENTTIALS);
        }

        mapper.writeValue(res.getOutputStream(), status);
    }
}
