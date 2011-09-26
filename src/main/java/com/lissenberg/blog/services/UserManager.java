package com.lissenberg.blog.services;


import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.lissenberg.blog.domain.User;
import com.lissenberg.blog.domain.UserRole;

@Named
@SessionScoped
public class UserManager implements Serializable {

	private static final User anonymousUser = new User(-999L, "anonymous", "Anonymous visitor", Collections.singleton(UserRole.READER));

	private User user;

	@Produces
	@Named
	public User signedInUser() {
		if (user == null) {
			return anonymousUser;
		} else {
			return user;
		}
	}

	public void logon(String username, String password) {
		Set<UserRole> roles = new HashSet<UserRole>();
		roles.add(UserRole.READER);
		roles.add(UserRole.WRITER);
		user = new User(12L, username, username, roles);
	}

}
