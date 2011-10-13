package com.lissenberg.blog.services;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * @author Harro Lissenberg
 */
@RunWith(Arquillian.class)
public class BlogServiceTest {

//	@Deployment
//	public static JavaArchive createDeployment() {
//		JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "test.jar")
//				.addPackages(true, "com.lissenberg.blog")
//				.addAsResource("META-INF/arquillian-persistence.xml", "META-INF/persistence.xml")
//				.addAsResource(EmptyAsset.INSTANCE, "beans.xml");
//
//		return jar;
//	}

    @EJB
    private BlogService blogService;

    @Test
    public void testInsertBlog() throws Exception {
        Assert.assertTrue(blogService.getLatestPosts(0, 1).size() > 1);
    }


}
