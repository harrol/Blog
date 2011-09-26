package com.lissenberg.blog;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.domain.User;
import com.lissenberg.blog.domain.UserRole;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * A simple JPA test. Later we will use Arquillian for in-container testing which will simplify
 * persistence (testing) a lot.
 */
public class SimplePersistenceTest {
    
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;
   
    @BeforeClass
    public static void init() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("in-memory-test-db");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void destroy() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Before
    public void initTransaction() {
        entityTransaction = entityManager.getTransaction();
    }

    @Test
    public void testInsertBlog() {
        User user = new User();
        user.setName("name");
        user.setUsername("username");
        user.setRoles(new HashSet<UserRole>(Arrays.asList(UserRole.WRITER, UserRole.READER)));
        BlogPost post = new BlogPost();
        post.setAuthor(user);
        post.setPosted(new Date());
        post.setText("Lorum Ipsum");
        post.setTitle("Test post title");
        
        entityTransaction.begin();
        entityManager.persist(user);
        entityManager.persist(post);
        entityTransaction.commit();
        assertNotNull(post.getId());
    }
}
