package com.lissenberg.blog.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lissenberg.blog.domain.User;

/**
 * @author Harro Lissenberg
 */
@Stateless
public class UserService {
	
	@PersistenceContext
	EntityManager entityManager;

	@Inject
	SecurityService securityService;
	
	public void saveUser(User user, String password) {
		user.setPasswordHash(securityService.createHash(password));
		password = null;
		entityManager.persist(user);
	}
			
}
