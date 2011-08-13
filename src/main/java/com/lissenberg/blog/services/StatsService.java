package com.lissenberg.blog.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;

import com.lissenberg.blog.domain.Statistics;

@Singleton
@Named
public class StatsService {

	private Map<Long, Statistics> stats;

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
		Statistics statistics = stats.get(blogId);
		if (statistics == null) {
			statistics = new Statistics();
			statistics.setBlogId(blogId);
			statistics.setFirstVisit(now);
			statistics.setLastVisit(now);
			statistics.setHits(1);
			stats.put(blogId, statistics);
		} else {
			statistics.setLastVisit(now);
			statistics.addHit();
		}
		return statistics;
	}

	@PostConstruct
	public void init() {
		stats = new HashMap<Long, Statistics>();
	}

}
