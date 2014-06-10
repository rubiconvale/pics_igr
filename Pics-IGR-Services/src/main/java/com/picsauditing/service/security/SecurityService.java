package com.picsauditing.service.security;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
public interface SecurityService {

    /**
     * Encodes the password using SHAPassword encoder, gets current username as salt from logged in user
     * @param password The clear password to encode
     * @return Encoded password
     */
	public String encodePassword(String password);

    /**
     * Encodes the password using SHAPassword encoder, gets current username as salt from logged in user
     * @param password The clear password to encode
     * @return Encoded password
     */
    public String encodePassword(String password, String username);
}


