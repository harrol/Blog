package com.lissenberg.blog.services;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.domain.Comment;
import com.lissenberg.blog.util.Performance;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
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

    @Inject
    Event<BlogPost> event;

    public void savePost(BlogPost post) {
        entityManager.persist(post);
        event.fire(post);
    }

    public void updatePost(BlogPost post) {
        entityManager.merge(post);
    }

    /**
     * Returns the latest, most recent, post
     *
     * @return the latest blog post
     */
    public BlogPost getLatestPost() {
        return getLatestPosts(0, 1).get(0);
    }


    public void saveComment(Comment comment) {
        entityManager.persist(comment);
    }

    /**
     * Returns all comments for the given blog post
     *
     * @param blogId
     * @return a list of comments
     */
    public List<Comment> getCommentsForPost(Long blogId) {
        Query query = entityManager.createQuery("select c from blog_comment c where c.blogId = :blogId order by c.posted asc", Comment.class);
        query.setParameter("blogId", blogId);
        return query.getResultList();
    }

}
