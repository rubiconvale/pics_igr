package com.picsauditing.data.security.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_information")
@PrimaryKeyJoinColumn(name="user_id")
@NamedNativeQueries({
        @NamedNativeQuery(name="UserInformation.findAllUsers", query="select * from UserInformation ui"),
        @NamedNativeQuery(name="UserInformation.findByUsername",
                    query="select * from UserInformation ui where ui.username = ?"),
        @NamedNativeQuery(name = "UserInformation.findByLastInitial",
                query = "select * from UserInformation ui " +
                        "where lower(substring(ui.lastName,1,1)) = ?"),

        @NamedNativeQuery(name="UserInformation.findByAgency", query="SELECT *\n" +
                "                FROM user_information ui\n" +
                "                    JOIN users u ON u.user_id = ui.user_id\n" +
                "                    JOIN user_rma_agencies ura ON ui.user_id = ura.user_id\n" +
                "                WHERE ura.object_id = ?1",
                resultClass = UserInformation.class),
        @NamedNativeQuery(name="UserInformation.findByJurisdiction", query="SELECT *\n" +
                "                FROM user_information ui\n" +
                "                    JOIN users u ON u.user_id = ui.user_id\n" +
                "                    JOIN user_rma_agencies ura ON ui.user_id = ura.user_id\n" +
                "                    JOIN agency a ON a.object_id = ura.object_id\n" +
                "                WHERE a.jurisdiction = ?1",
                resultClass = UserInformation.class),
        @NamedNativeQuery(name="UserInformation.findByLastInitialAgency", query="SELECT *\n" +
                "                FROM user_information ui\n" +
                "                   JOIN users u ON u.user_id = ui.user_id\n" +
                "                   JOIN user_rma_agencies ura ON ui.user_id = ura.user_id\n" +
                "                   JOIN agency a ON a.object_id = ura.object_id\n" +
                "                WHERE lower(substring(ui.lastname,1,1)) = ?1" +
                "                   AND a.object_id = ?2",
                resultClass = UserInformation.class),
        @NamedNativeQuery(name="UserInformation.findByLastInitialJurisdiction", query="SELECT\n" +
                "                *\n" +
                "                FROM user_information ui\n" +
                "                   JOIN users u ON u.user_id = ui.user_id\n" +
                "                   JOIN user_rma_agencies ura ON ui.user_id = ura.user_id\n" +
                "                   JOIN agency a ON a.object_id = ura.object_id\n" +
                "                WHERE\n" +
                "                   LOWER(SUBSTRING(ui.lastname,1,1)) = ?1\n" +
                "                   AND a.jurisdiction = ?2",
                resultClass = UserInformation.class)
})
public class UserInformation extends User{

	private static final long serialVersionUID = 5876696486980688169L;

	@Basic
	@Column(name = "firstname")
	private String firstName;

	@Basic
	@Column(name = "middleName")
	private String middleName;

	@Basic
	@Column(name = "lastName")
	private String lastName;

	@Basic
	@Column(name = "email")
	private String email;

    @Basic
    @Column(name="user_description")
    private String userDescription;

	@Basic
	@Column(name = "create_date", nullable = false, insertable = true, updatable = false)
	private Date createDate;

	@Basic
	@Column(name = "create_user", nullable = true, insertable = true, updatable = false)
	private Long createUser;

	@Basic
	@Column(name = "modified_date")
	private Date modifiedDate;

	@Basic
	@Column(name = "modified_user")
	private Long modifiedUser;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(Long modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    // do not edit below this line

    @Temporal(TemporalType.TIMESTAMP)

	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)

	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

    @PrePersist
	protected void onPersist() {
		this.setCreateDate(new DateTime().toDate());

		// not sure I like this here, probably better in service or domaindao layer
		//	this.setCreateUser(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
	}

	@PreUpdate
	protected void onUpdate() {
		this.setModifiedDate(new DateTime().toDate());

		// not sure I like this here, probably better in service or domaindao layer
		//	this.setModifiedUser(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId());
	}

	@Override
	public String toString(){ return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE); }

}
