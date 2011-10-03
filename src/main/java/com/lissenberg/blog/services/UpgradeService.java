package com.lissenberg.blog.services;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.domain.Statistics;
import com.lissenberg.blog.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class is used to update database tables or data when required.
 * Using @PostConstruct method to automatically run it's initialisation methods.
 *
 * @author Harro Lissenberg
 */
@Singleton
public class UpgradeService {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    BlogService blogService;

    @PostConstruct
    public void createAdminUser() {
        if(blogService.getLatestPosts(0, 5).size() > 0) {
            // already inserted
            return;
        }
        User admin = new User();
        admin.setName("Administrator");
        admin.setUsername("admin");
        entityManager.persist(admin);

        // create first post
        BlogPost post = new BlogPost();
        post.setAuthor(admin);
        post.setTitle("First post!");
        post.setText("Java EE 6 is almost 2 years old and I never got the change to work with it in a " +
                "profession environment. All current projects my company runs still use old and trusted frameworks.<br/>" +
                "I decided to take matters into my own hands and started this quest to learn Java EE 6." +
                " Wanting to do a little bit more than just a Hello World application and decided to build" +
                " blogging software using nothing but plain vanilla Java EE 6 (and perhaps a JSF component library)" +
                " and at the same time use it to blog about my adventures.<br/>" +
                "Over time more and more features should be implemented that turn this site into a decent blog.<br/><br/>" +
                "It starts now...");


        entityManager.persist(post);

        Statistics stats = new Statistics();
        stats.setBlogId(post.getId());
        stats.setHits(0);

        entityManager.persist(stats);
    }


}
