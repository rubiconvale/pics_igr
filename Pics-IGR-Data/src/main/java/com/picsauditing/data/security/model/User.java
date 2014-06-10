package com.picsauditing.data.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedNativeQueries({
        @NamedNativeQuery(name = "User.findAllUsers", query = "select * from User"),
        @NamedNativeQuery(name = "User.findByUsername", query = "select * from User u where u.username = ?")
})
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 5095442105821492288L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "user_id", nullable = false, insertable = true, updatable = false, length = 19, precision = 0)
    private Long userId;

    @Basic
    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    private String username;

    @Basic
    @JsonIgnore
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 50, precision = 0, columnDefinition = "string default f935373f5cbda8c374452b125c8d6910afea7aed")
    private String password;

    @Basic
    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default false")
    private boolean enabled;

    @Basic
    @Column(name = "account_non_expired", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean accountNonExpired;

    @Basic
    @Column(name = "account_non_locked", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean accountNonLocked;

    @Basic
    @Column(name = "credentials_non_expired", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean credentialsNonExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_authorities",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private Set<Authority> authorities;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_groups",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private Set<Group> groups;

    // test comment

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_rma_agencies",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "object_id")})
    private Set<BaseObject> baseObjects;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * @return the Authorities assigned to this User and the Authorities assigned to the User's groups.
     */
    public Set<Authority> getAuthorities() {
        Set<Authority> userAndGroupAuthorities = new TreeSet<>(authorities);

        if (groups != null) {
            for (Group group : groups) {
                userAndGroupAuthorities.addAll(group.getAuthorities());
            }
        }
        return userAndGroupAuthorities;
    }

    /**
     * Sets Authorities directly on this User instance (does not assign any authorities to the user's groups).
     *
     * @param authorities the set of Authorities to assign to this User instance
     */
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    /**
     * @return the Authorities assigned directly to this user (excludes those assigned to the User's groups).
     */
    public Set<Authority> getUserAuthorities() {
        return authorities;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<BaseObject> getBaseObjects() {
        return baseObjects;
    }

    public void setBaseObjects(Set<BaseObject> baseObjects) {
        this.baseObjects = baseObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (accountNonExpired != user.accountNonExpired) return false;
        if (accountNonLocked != user.accountNonLocked) return false;
        if (credentialsNonExpired != user.credentialsNonExpired) return false;
        if (enabled != user.enabled) return false;
        if (!password.equals(user.password)) return false;
        if (!username.equals(user.username)) return false;
        if (!groups.equals(user.groups)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (accountNonExpired ? 1 : 0);
        result = 31 * result + (accountNonLocked ? 1 : 0);
        result = 31 * result + (credentialsNonExpired ? 1 : 0);
        result = 31 * result + groups.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
