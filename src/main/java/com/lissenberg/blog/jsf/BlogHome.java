package com.lissenberg.blog.jsf;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.domain.Statistics;
import com.lissenberg.blog.services.BlogService;
import com.lissenberg.blog.services.StatsService;
import com.lissenberg.blog.services.TimeService;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * Homepage
 *
 * @author Harro Lissenberg
 */
@Model
public class BlogHome implements Serializable {

    @EJB
    private BlogService blogService;
    @EJB
    private StatsService statsService;
    @EJB
    private TimeService timeService;

    public BlogPost getCurrentPost() {
        return blogService.getLatestPosts(0, 10).get(0);
    }

    public Statistics getStatistics(Long blogId) {
        return statsService.updateStatistics(blogId);
    }

    public String getTheTime() {
        return formatTime(new Date());
    }

    public String formatTime(final Date date) {
        return timeService.getFormattedDate(date);
    }


}
