
package com.picsauditing.data.security.model;

import com.picsauditing.constants.BaseObjectType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


//TODO base object table
@Inheritance(strategy=InheritanceType.JOINED)
@NamedNativeQueries({
		@NamedNativeQuery(name="BaseObject.findByName", query="select * from BaseObject e where e.name = ?")
})
public class BaseObject implements Serializable {

	private static final long serialVersionUID = 8246581571217572974L;

/*	@Id
/%
    @JsonSerialize(using=ToStringSerializer.class)
    @GeneratedValue(generator = "LexObjStrategy")
	@GenericGenerator(name="LexObjStrategy", strategy = "com.com.model.identifier.BaseObjectIdentifier")*/
	@Column(name = "object_id", updatable = false, length = 19, precision = 0)
	private Long objectId;

	@Basic
	@Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
	private String name;

	@Basic
	@Enumerated(EnumType.STRING)
	@Column(name = "object_type", nullable = false, insertable = true, updatable = false)
	private BaseObjectType baseObjectType;

	@Basic
	@Column(name = "enabled", nullable = false, columnDefinition = "BIT", length = 1)
	private Boolean enabled = Boolean.TRUE;

	@Basic
	@Column(name = "object_non_expired", nullable = false, columnDefinition = "BIT", length = 1)
	private Boolean objectNonExpired = Boolean.TRUE;

	@Basic
	@Column(name = "object_non_locked", nullable = false, columnDefinition = "BIT", length = 1)
	private Boolean objectNonLocked = Boolean.TRUE;

	@Basic
	@Column(name = "create_date", nullable = false, insertable = true, updatable = false)
	private Date createDate;

	@Basic
	@Column(name = "create_user", nullable = true, insertable = true, updatable = false)
	private Long createUser;

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean isObjectNonExpired() {
		return objectNonExpired;
	}

	public void setObjectNonExpired(Boolean objectNonExpired) {
		this.objectNonExpired = objectNonExpired;
	}

	public Boolean isObjectNonLocked() {
		return objectNonLocked;
	}

	public void setObjectNonLocked(Boolean objectNonLocked) {
		this.objectNonLocked = objectNonLocked;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@PrePersist
	protected void onPersist() {
		setCreateDate(new DateTime().toDate());
	}


	@Override
	public String toString(){ return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE); }
}
