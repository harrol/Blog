package com.lissenberg.blog.domain;

/**
 * User: harro Date: 5/7/11 Time: 10:59 PM
 */
public class User {
	private Long id;
	private String username;
	private String name;

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
