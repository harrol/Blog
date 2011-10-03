package com.lissenberg.blog.jsf;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.domain.Statistics;
import com.lissenberg.blog.services.BlogService;
import com.lissenberg.blog.services.StatsService;
import com.lissenberg.blog.services.TimeService;

/**
 * Homepage
 *
 * @author Harro Lissenberg
 */
@Model
public class BlogHome implements Serializable {

	@Inject
	private BlogService blogService;
	@Inject
	private StatsService statsService;
    
    @Inject
    private TimeService timeService;

	public BlogPost getThePost() {
		return blogService.getLatestPosts(0, 10).get(0);
	}

	public Statistics getStatistics(Long blogId) {
		return statsService.updateStatistics(blogId);
	}
    
    public String getTheTime() {
        return timeService.getFormattedDate();
    }


}
