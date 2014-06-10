package com.picsauditing.data.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PicsLdapUserDetailsContextMapper implements UserDetailsContextMapper, Serializable {

	private static final long serialVersionUID = -2096956744445351971L;
	final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public UserDetails mapUserFromContext(DirContextOperations dirContextOperations, String s, Collection<? extends GrantedAuthority> grantedAuthorities) {

		List<GrantedAuthority> mappedAuthorities = new ArrayList<GrantedAuthority>();

		PicsLdapUserDetails user = new PicsLdapUserDetails();

		dirContextOperations.getNameInNamespace();

		user.setDn(dirContextOperations.getNameInNamespace());
		user.setUsername(s);
		user.setName(dirContextOperations.getStringAttribute("name"));
		user.setEmail(dirContextOperations.getStringAttribute("mail"));
		user.setCompany(dirContextOperations.getStringAttribute("company"));
		user.setPassword("");

		for (GrantedAuthority granted : grantedAuthorities) {

			if (granted.getAuthority().equalsIgnoreCase("ROLE_PICS")) {
				mappedAuthorities.add(new GrantedAuthority(){
					private static final long serialVersionUID = 41L;

					@Override
					public String getAuthority() {
						return "ROLE_USER";
					}

				});
			} else if(granted.getAuthority().equalsIgnoreCase("Developers")) {
				mappedAuthorities.add(new GrantedAuthority() {
					private static final long serialVersionUID = -51L;

					@Override
					public String getAuthority() {
						return "ROLE_ADMIN";
					}
				});
				mappedAuthorities.add(new GrantedAuthority() {
					private static final long serialVersionUID = -51L;

					@Override
					public String getAuthority() {
						return "ROLE_USER";
					}
				});
			}
		}

		user.setAuthorities(mappedAuthorities);

		return user;
	}

	@Override
	public void mapUserToContext(UserDetails userDetails, DirContextAdapter dirContextAdapter) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
