package com.picsauditing.web.model;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import java.io.Serializable;

/**
 * @Author RNatarajan on 6/8/2014.
 * Modification Log :
 */
public class ContractorInfoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String billingContact;

    public String getBillingContact() {
        return billingContact;
    }

    public void setBillingContact(String billingContact) {
        this.billingContact = billingContact;
    }

    private String billingPhone;

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    private String billingEmail;

  }
