package com.lissenberg.blog.domain;

import java.util.Set;

import javax.persistence.*;

/**
 * @author Harro Lissenberg
 */
@Entity(name = "blog_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String name;
    @Enumerated(value = EnumType.STRING)
	private UserRole role;
    private String passwordHash;


    public User(Long id, String username, String name, UserRole role) {
		this.id = id;
		this.username = username;
		this.name = name;
        this.role = role;
	}

	public User() {
	}

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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
