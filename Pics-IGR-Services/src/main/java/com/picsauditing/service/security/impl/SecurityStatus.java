package com.picsauditing.service.security.impl;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.data.security.constants.SecurityStatusType;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
public class SecurityStatus{

    private String username;
    private String email;
    private String errorMessage;
    private boolean success;
    private boolean loggedIn;
    private SecurityStatusType securityStatusType;

    private boolean accountLocked;
    private boolean credentialsExpired;

    public SecurityStatus(String username, boolean loggedIn, boolean success, String errorMessage) {
        this.errorMessage = errorMessage;
        this.username = username;
        this.success = success;
        this.loggedIn = loggedIn;
        this.accountLocked = false;
        this.credentialsExpired = false;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public SecurityStatusType getSecurityStatusType() {
        return securityStatusType;
    }

    public void setSecurityStatusType(SecurityStatusType securityStatusType) {
        this.securityStatusType = securityStatusType;
        this.setErrorMessage(securityStatusType.getDescription());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
