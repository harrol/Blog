package com.lissenberg.blog.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Holds statistics for a blog post
 *
 * @author Harro Lissenberg
 */
@Entity(name = "blog_stats")
public class Statistics {

    @Id
    private Long blogId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstVisit;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastVisit;
    private Integer hits;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Date getFirstVisit() {
        return firstVisit;
    }

    public void setFirstVisit(Date firstVisit) {
        this.firstVisit = firstVisit;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }
}
