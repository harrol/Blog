package com.lissenberg.blog.services;

import com.lissenberg.blog.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 * This class is used to update database tables or data when required.
 * Using @PostConstruct method to automatically run it's initialisation methods.
 */
@Singleton
public class UpgradeService {

    @PostConstruct
    public void createAdminUser() {
        User admin = new User();
        admin.setName("Administrator");
        admin.setUsername("admin");
        admin.setUnEncryptedPassword("secret");
    }
    
    
    @PostConstruct
    public void createFirstPost() {

    }
}
