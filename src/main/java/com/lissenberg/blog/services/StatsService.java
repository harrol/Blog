package com.lissenberg.blog.services;

import com.lissenberg.blog.domain.RequestInfo;
import com.lissenberg.blog.domain.Statistics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Statistics service
 *
 * @author Harro Lissenberg
 */
@Stateless
public class StatsService {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Updates and returns the statistics for the specified blog post.
     * <p/>
     * TODO This is not thread safe; SSB incrementing the hit counter
     *
     * @param blogId the blog id
     * @return updated statistics
     */
    public Statistics updateStatistics(Long blogId, RequestInfo requestInfo) {
        Date now = new Date();
        entityManager.persist(requestInfo);
        Statistics statistics = entityManager.find(Statistics.class, blogId);
        if (statistics == null) {
            statistics = new Statistics();
            statistics.setBlogId(blogId);
            statistics.setFirstVisit(now);
            statistics.setLastVisit(now);
            statistics.setHits(1);
            entityManager.persist(statistics);
        } else {
            statistics.setLastVisit(now);
            statistics.addHit();
            entityManager.merge(statistics);
        }
        entityManager.flush();
        entityManager.detach(statistics);
        entityManager.detach(requestInfo);
        return statistics;
    }

    /**
     * Returns the 100 latest requests
     *
     * @param blogId the blog id
     * @return requests for the blog
     */
    public List<RequestInfo> getRequestInfoForPost(Long blogId) {
        Query query = entityManager.createQuery("select r from blog_req_info r where r.blogId = :blogId order by r.visit desc", RequestInfo.class);
        query.setParameter("blogId", blogId);
        query.setMaxResults(100);
        return query.getResultList();
    }

    /**
     * Returns the 100 latest requests
     *
     * @return requests
     */
    public List<RequestInfo> getRequestInfo() {
        Query query = entityManager.createQuery("select r from blog_req_info r order by r.visit desc", RequestInfo.class);
        query.setMaxResults(100);
        return query.getResultList();
    }


}
