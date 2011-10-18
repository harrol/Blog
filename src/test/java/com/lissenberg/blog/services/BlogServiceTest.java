package com.lissenberg.blog.services;

import java.util.Date;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.domain.User;
import com.lissenberg.blog.domain.UserRole;

/**
 * @author Harro Lissenberg
 */
@RunWith(Arquillian.class)
public class BlogServiceTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addPackages(true, "com.lissenberg.blog")
				.addAsResource("META-INF/arquillian-persistence.xml", "META-INF/persistence.xml")
				.addAsResource(EmptyAsset.INSTANCE, "META-INF/beans.xml");
	}

    @EJB
    private BlogService blogService;
	@EJB
	private UserService userService;

    @Test
    public void testInsertBlog() throws Exception {
		// upgrader should have inserted first post
		BlogPost firstPost = blogService.getLatestPost();
        Assert.assertNotNull(firstPost);

		User user = new User();
		user.setUsername("test_user_" + System.currentTimeMillis());
		user.setName("Test user");
		user.setRole(UserRole.WRITER);
		userService.saveUser(user, "secret");

		BlogPost newPost = new BlogPost();
		newPost.setAuthor(user);
		newPost.setPosted(new Date());
		newPost.setTitle("Test title");
		newPost.setText("This is a test post.");
		blogService.savePost(newPost);
		
		BlogPost latestPost = blogService.getLatestPost();
		Assert.assertNotSame(firstPost.getId(), latestPost.getId());
		Assert.assertEquals(newPost.getId(), latestPost.getId());

    }


}
