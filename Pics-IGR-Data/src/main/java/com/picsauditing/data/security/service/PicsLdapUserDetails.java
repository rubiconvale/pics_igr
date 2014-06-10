package com.picsauditing.data.security.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;

import java.util.List;

public class PicsLdapUserDetails extends LdapUserDetailsImpl {

	private static final long serialVersionUID = 7756420688547317471L;
	private String dn;
	private String password;
	private String username;
	private List <GrantedAuthority>authorities = AuthorityUtils.NO_AUTHORITIES;

	private String ticket;
	private String name;
	private String email;
	private String company;

	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

	@JsonIgnore
	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof LdapUserDetailsImpl) {
			return dn.equals(((LdapUserDetailsImpl)o).getDn());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return dn.hashCode();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString()).append(": ");
		sb.append("Name: ").append(this.name).append("; ");
		sb.append("Company: ").append(this.company).append("; ");
		sb.append("Email: ").append(this.email).append("; ");
		sb.append("Username: ").append(this.username).append("; ");
		sb.append("Password: [PROTECTED]; ");
		sb.append("Enabled: ").append(this.enabled).append("; ");
		sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");
		sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");
		sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");
		if (this.getAuthorities() != null) {
			sb.append("Granted Authority: ");
			boolean first = true;

			for (Object authority : this.getAuthorities()) {
				if (first) {
					first = false;
				} else {
					sb.append(", ");
				}
				sb.append(authority.toString());
		}
	} else {
		sb.append("PICS Auditing user does not have granted any authorities");
	}
	return sb.toString();
	}
}
