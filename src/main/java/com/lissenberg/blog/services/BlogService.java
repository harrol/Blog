package com.lissenberg.blog.services;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.util.Performance;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Harro Lissenberg
 */
@Stateless
public class BlogService {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Returns a list of blog posts ordered by date. Newest first.
     *
     * @param start    the first post to fetch, can be used for paging
     * @param maxPosts the amount of post to return.
     * @return a list of blog posts
     */
    @Performance
    public List<BlogPost> getLatestPosts(int start, int maxPosts) {
        Query query = entityManager.createQuery("select p from blog_post p order by p.posted desc");
        query.setFirstResult(start);
        query.setMaxResults(maxPosts);
        return query.getResultList();
    }

    public BlogPost getPost(long id) {
        return entityManager.find(BlogPost.class, id);
    }

    public void savePost(BlogPost post) {
        entityManager.persist(post);
    }

}
