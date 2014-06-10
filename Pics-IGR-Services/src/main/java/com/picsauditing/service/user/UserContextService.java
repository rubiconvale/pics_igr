package com.picsauditing.service.user;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.data.security.model.User;
/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
public interface UserContextService {

	public boolean isAdmin();
	public boolean isAuthor();
	public boolean isAgencyUser();
	public boolean isAgencyAdmin();
	public boolean isAuthorizedToEdit(Object obj);

    public Long getCurrentUserId();
	public String getCurrentUserName();
	public User getCurrentUser();

}
