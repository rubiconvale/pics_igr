package com.picsauditing.service.security.impl;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    final Logger log = LoggerFactory.getLogger("org.springframework.security");

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {
        log.error("Login Success for [{}] from [{}]", auth.getName(), ((WebAuthenticationDetails) auth.getDetails()).getRemoteAddress());

        SecurityStatus status = new SecurityStatus(auth.getName(), auth.isAuthenticated(), true, null);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(res.getOutputStream(), status);
    }
}
