package com.picsauditing.data.model.entity;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */


import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
@Entity
@javax.persistence.Table(name = "contractor_info", catalog = "pics_dev")

@NamedNativeQueries(
        {
                @NamedNativeQuery(name = "ContractorInfo.findContractorByAccountName",
                        query = "select * from Contractor_Info c left join accounts a on c.id=a.id where a.name=:name ",
                        resultClass = ContractorInfo.class)
        }
)
/**TODO
 * @NamedQueries(
 * {
 *     @NamedQuery(.....)
 * }
 * )
 */
public class ContractorInfo extends BaseModel implements Serializable {
    private int id;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String description;

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Integer requestedById;

    @Basic
    @Column(name = "requestedByID", nullable = true, insertable = true, updatable = true)
    public Integer getRequestedById() {
        return requestedById;
    }

    public void setRequestedById(Integer requestedById) {
        this.requestedById = requestedById;
    }

    private String billingContact;

    @Basic
    @Column(name = "billingContact", nullable = true, insertable = true, updatable = true, length = 50)
    public String getBillingContact() {
        return billingContact;
    }

    public void setBillingContact(String billingContact) {
        this.billingContact = billingContact;
    }

    private String billingPhone;

    @Basic
    @Column(name = "billingPhone", nullable = true, insertable = true, updatable = true, length = 50)
    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    private String billingEmail;

    @Basic
    @Column(name = "billingEmail", nullable = true, insertable = true, updatable = true, length = 50)
    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    private String billingAddress;

    @Basic
    @Column(name = "billingAddress", nullable = true, insertable = true, updatable = true, length = 50)
    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    private String billingCity;

    @Basic
    @Column(name = "billingCity", nullable = true, insertable = true, updatable = true, length = 35)
    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    private String billingCountrySubdivision;

    @Basic
    @Column(name = "billingCountrySubdivision", nullable = true, insertable = true, updatable = true, length = 10)
    public String getBillingCountrySubdivision() {
        return billingCountrySubdivision;
    }

    public void setBillingCountrySubdivision(String billingCountrySubdivision) {
        this.billingCountrySubdivision = billingCountrySubdivision;
    }

    private String billingZip;

    @Basic
    @Column(name = "billingZip", nullable = true, insertable = true, updatable = true, length = 10)
    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    private String billingCountry;

    @Basic
    @Column(name = "billingCountry", nullable = true, insertable = true, updatable = true, length = 25)
    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    private Date membershipDate;

    @Basic
    @Column(name = "membershipDate", nullable = true, insertable = true, updatable = true)
    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    private Short membershipLevelId;

    @Basic
    @Column(name = "membershipLevelID", nullable = true, insertable = true, updatable = true)
    public Short getMembershipLevelId() {
        return membershipLevelId;
    }

    public void setMembershipLevelId(Short membershipLevelId) {
        this.membershipLevelId = membershipLevelId;
    }

    private Date ccExpiration;

    @Basic
    @Column(name = "ccExpiration", nullable = true, insertable = true, updatable = true)
    public Date getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(Date ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    private String ccEmail;

    @Basic
    @Column(name = "ccEmail", nullable = true, insertable = true, updatable = true, length = 50)
    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    private String accountLevel;

    @Basic
    @Column(name = "accountLevel", nullable = true, insertable = true, updatable = true, length = 20)
    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractorInfo that = (ContractorInfo) o;

        if (id != that.id) return false;
        if (accountLevel != null ? !accountLevel.equals(that.accountLevel) : that.accountLevel != null) return false;
        if (billingAddress != null ? !billingAddress.equals(that.billingAddress) : that.billingAddress != null)
            return false;
        if (billingCity != null ? !billingCity.equals(that.billingCity) : that.billingCity != null) return false;
        if (billingContact != null ? !billingContact.equals(that.billingContact) : that.billingContact != null)
            return false;
        if (billingCountry != null ? !billingCountry.equals(that.billingCountry) : that.billingCountry != null)
            return false;
        if (billingCountrySubdivision != null ? !billingCountrySubdivision.equals(that.billingCountrySubdivision) : that.billingCountrySubdivision != null)
            return false;
        if (billingEmail != null ? !billingEmail.equals(that.billingEmail) : that.billingEmail != null) return false;
        if (billingPhone != null ? !billingPhone.equals(that.billingPhone) : that.billingPhone != null) return false;
        if (billingZip != null ? !billingZip.equals(that.billingZip) : that.billingZip != null) return false;
        if (ccEmail != null ? !ccEmail.equals(that.ccEmail) : that.ccEmail != null) return false;
        if (ccExpiration != null ? !ccExpiration.equals(that.ccExpiration) : that.ccExpiration != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (membershipDate != null ? !membershipDate.equals(that.membershipDate) : that.membershipDate != null)
            return false;
        if (membershipLevelId != null ? !membershipLevelId.equals(that.membershipLevelId) : that.membershipLevelId != null)
            return false;
        if (requestedById != null ? !requestedById.equals(that.requestedById) : that.requestedById != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (requestedById != null ? requestedById.hashCode() : 0);
        result = 31 * result + (billingContact != null ? billingContact.hashCode() : 0);
        result = 31 * result + (billingPhone != null ? billingPhone.hashCode() : 0);
        result = 31 * result + (billingEmail != null ? billingEmail.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        result = 31 * result + (billingCity != null ? billingCity.hashCode() : 0);
        result = 31 * result + (billingCountrySubdivision != null ? billingCountrySubdivision.hashCode() : 0);
        result = 31 * result + (billingZip != null ? billingZip.hashCode() : 0);
        result = 31 * result + (billingCountry != null ? billingCountry.hashCode() : 0);
        result = 31 * result + (membershipDate != null ? membershipDate.hashCode() : 0);
        result = 31 * result + (membershipLevelId != null ? membershipLevelId.hashCode() : 0);
        result = 31 * result + (ccExpiration != null ? ccExpiration.hashCode() : 0);
        result = 31 * result + (ccEmail != null ? ccEmail.hashCode() : 0);
        result = 31 * result + (accountLevel != null ? accountLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
