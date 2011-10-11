package com.lissenberg.blog.services;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;

/**
 * @author Harro Lissenberg
 */
@RunWith(Arquillian.class)
public class BlogServiceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addPackage("com.lissenberg.blog.*")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @EJB
    private BlogService blogService;

    @Test
    public void testInsertBlog() throws Exception {
        Assert.assertTrue(blogService.getLatestPosts(0, 1).size() > 1);
    }


}
