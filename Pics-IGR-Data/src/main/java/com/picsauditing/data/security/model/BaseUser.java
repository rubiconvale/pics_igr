

package com.picsauditing.data.security.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
		@NamedQuery(name="BaseUser.findAllUsers", query="from BaseUser u"),
		@NamedQuery(name="BaseUser.findByUsername", query="from BaseUser u where u.username = ?")
})
public class BaseUser implements Serializable {

    private static final long serialVersionUID = 3610951550873762750L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @JsonSerialize(using=ToStringSerializer.class)
    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
	private Long userId;

	@Basic
	@Column(name = "username", nullable = false, insertable = false, updatable = false)
	private String username;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
	public String toString(){ return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE); }
}
