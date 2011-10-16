package com.lissenberg.blog.services;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.domain.User;
import com.lissenberg.blog.util.Log;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * This class is used to update database tables or data when required.
 * Using @PostConstruct method to automatically run it's initialisation methods.
 *
 * @author Harro Lissenberg
 */
@Startup
@Singleton
public class UpgradeService {

    @Inject
    @Log
    Logger LOG;

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    BlogService blogService;

    @EJB
    SecurityService securityService;

    @PostConstruct
    public void updateDatabase() {
        if (blogService.getLatestPosts(0, 2).size() > 0) {
            // already inserted
            LOG.info("No upgrades required");
            return;
        }
        LOG.info("Inserting administrator");
        User admin = new User();
        admin.setName("Administrator");
        admin.setUsername("admin");
        // TODO do not create an user by default, but create on deployment
        admin.setPasswordHash(securityService.createHash("secret"));
        entityManager.persist(admin);

        LOG.info("Inserting first post");
        // create first post
        BlogPost post = new BlogPost();
        post.setAuthor(admin);
        post.setTitle("First post!");
        post.setText("Java EE 6 is almost 2 years old and I never got the change to work with it in a " +
                "professional environment. All current projects my company runs still use old and trusted frameworks.<br/>" +
                "I decided to take matters into my own hands and started this quest to learn Java EE 6." +
                " Wanting to do a little bit more than just a Hello World application and decided to build" +
                " blogging software using nothing but plain vanilla Java EE 6 (and perhaps a JSF component library)" +
                " and at the same time use it to blog about my adventures.<br/>" +
                "Over time more and more features should be implemented that turn this site into a decent blog.<br/><br/>" +
                "It starts now...");


        blogService.savePost(post);
    }


}
