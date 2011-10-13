package com.lissenberg.blog.services;

import com.lissenberg.blog.domain.RequestInfo;
import com.lissenberg.blog.domain.Statistics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

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

}
