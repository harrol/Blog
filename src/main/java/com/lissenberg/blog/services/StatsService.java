package com.lissenberg.blog.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lissenberg.blog.domain.Statistics;

/**
 * Statistics service
 * @author Harro Lissenberg
 */
@Stateless
public class StatsService {

    @PersistenceContext
    EntityManager entityManager;

	/**
	 * Updates and returns the statistics for the specified blog post.
	 *
	 * @param blogId
	 * 		the blog id
	 *
	 * @return updated statistics
	 */
	public Statistics updateStatistics(Long blogId) {
		Date now = new Date();
		Statistics statistics = entityManager.find(Statistics.class, blogId);
		if (statistics == null) {
			statistics = new Statistics();
			statistics.setFirstVisit(now);
			statistics.setLastVisit(now);
			statistics.setHits(1);
            entityManager.persist(statistics);
		} else {
			statistics.setLastVisit(now);
			statistics.addHit();
            entityManager.merge(statistics);
		}
        entityManager.detach(statistics);
		return statistics;
	}


}
