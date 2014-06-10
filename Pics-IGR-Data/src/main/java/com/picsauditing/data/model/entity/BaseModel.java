package com.picsauditing.data.model.entity;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
@MappedSuperclass


public class BaseModel implements Serializable{

    private static final long serialVersionUID = 1L;
    private Date creationDate;
    private String createdBy;
    private Date updateDate;
    private String updateBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate", nullable = false, length = 23)
    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "createdBy", nullable = false, length = 11)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateDate", length = 23)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Column(name = "updatedBy", length = 11)
    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  ReflectionToStringBuilder.toString(this);
    }
    @PrePersist
    protected void onPersist() {
        setCreationDate(Calendar.getInstance().getTime());
    }

}