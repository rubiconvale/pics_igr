package com.picsauditing.data.security.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "authority")
@NamedNativeQueries({
        @NamedNativeQuery(name = "Authority.findByAuthority", query = "select * from  Authority a where a.authority = ?"),
})
public class Authority implements Comparable<Authority>, GrantedAuthority {

    private static final long serialVersionUID = 6096788111510145032L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "authority_id", nullable = false, insertable = true, updatable = false, length = 19, precision = 0)
    private Long id;

    @Basic
    @Column(name = "authority", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    private String authority;

    @Basic
    @Column(name = "authority_description", nullable = true, insertable = true, updatable = true, length = 256, precision = 0)
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority = (Authority) o;

        if (!id.equals(authority.id)) return false;
        if (authority != null ? !authority.equals(authority.authority) : authority.authority != null) return false;
        if (description != null ? !authority.equals(authority.description) : authority.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public int compareTo(Authority o) {
        return authority.compareTo(o.authority);
    }
}
