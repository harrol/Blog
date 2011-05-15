package com.lissenberg.blog.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lissenberg.blog.services.UserManager;

@RequestScoped
@Named
public class LogonBean{

	@Inject private UserManager userManager;

	private String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String login() {
		userManager.logon(username, password);
		return "index.xhtml";
	}


}
