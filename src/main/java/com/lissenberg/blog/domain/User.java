package com.lissenberg.blog.domain;

import java.util.Set;

import javax.persistence.*;

/**
 * User: harro Date: 5/7/11 Time: 10:59 PM
 */
@Entity(name = "blog_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String name;
    @Transient
	private Set<UserRole> roles;
    @Transient
    private String unEncryptedPassword;
    private String passwordHash;


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

    public void setUnEncryptedPassword(String unEncryptedPassword) {
        this.unEncryptedPassword = unEncryptedPassword;
        createHash(unEncryptedPassword);
    }
    
    private void createHash(final String unEncryptedPassword) {
        String hash = username + "||" + unEncryptedPassword;
        this.passwordHash = hash;
    }
}
