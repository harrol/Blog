package com.lissenberg.blog.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Harro Lissenberg
 */
@Entity(name = "blog_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
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

    @Access(AccessType.PROPERTY)
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
