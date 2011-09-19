package com.lissenberg.blog.domain;

import java.util.Set;

import javax.management.relation.RoleStatus;

/**
 * User: harro Date: 5/7/11 Time: 10:59 PM
 */
public class User {
	private Long id;
	private String username;
	private String name;
	private Set<UserRole> roles;

	public User(Long id, String username, String name, Set<UserRole> roles) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.roles = roles;
	}

	public User() {
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
