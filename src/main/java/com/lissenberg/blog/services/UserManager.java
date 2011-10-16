package com.lissenberg.blog.services;


import com.lissenberg.blog.domain.User;
import com.lissenberg.blog.domain.UserRole;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;

/**
 * @author Harro Lissenberg
 */
@Named
@SessionScoped
public class UserManager implements Serializable {

    private static final User anonymousUser = new User(-999L, "anonymous", "Anonymous visitor", UserRole.READER);

    private User user;

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    private SecurityService securityService;


    @Produces
    @Named
    public User signedInUser() {
        if (user == null) {
            return anonymousUser;
        } else {
            return user;
        }
    }

    public boolean logon(final String username, final String password) {
        this.user = null;
        Query query = entityManager.createQuery("select u from blog_user u where u.username = :username and u.passwordHash = :passwordHash", User.class);
        query.setParameter("username", username);
        query.setParameter("passwordHash", securityService.createHash(password));
        try {
            user = (User) query.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            // user not found or wrong password
            return false;
        }
    }

}
