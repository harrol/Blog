package com.lissenberg.blog.jsf;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.domain.RequestInfo;
import com.lissenberg.blog.domain.Statistics;
import com.lissenberg.blog.services.BlogService;
import com.lissenberg.blog.services.StatsService;
import com.lissenberg.blog.services.TimeService;
import com.lissenberg.blog.util.Latest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

import static javax.faces.context.FacesContext.getCurrentInstance;

/**
 * Homepage
 *
 * @author Harro Lissenberg
 */
@Named
@RequestScoped
public class BlogHome {

    private static final String USER_AGENT = "user-agent";
    private static final String REFERER = "referer";

    @EJB
    private BlogService blogService;
    @EJB
    private StatsService statsService;
    @EJB
    private TimeService timeService;

    public BlogPost getLatestPost() {
        return blogService.getLatestPost();
    };



    public Statistics getStatistics(Long blogId) {
        ExternalContext ctx = getCurrentInstance().getExternalContext();
        String userAgent = ctx.getRequestHeaderMap().get(USER_AGENT);
        String referer = ctx.getRequestHeaderMap().get(REFERER);
        RequestInfo request = new RequestInfo(blogId, referer, userAgent);
        return statsService.updateStatistics(blogId, request);
    }

    public String getTheTime() {
        return formatTime(new Date());
    }

    public String formatTime(final Date date) {
        return timeService.getFormattedDate(date);
    }


}
