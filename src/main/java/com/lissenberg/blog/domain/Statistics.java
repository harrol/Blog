package com.lissenberg.blog.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Holds statistics for a blog post
 *
 * @author Harro Lissenberg
 */
@Entity(name = "blog_stats")
@Access(AccessType.PROPERTY)
public class Statistics {

    private Long blogId;
    private Date firstVisit;
    private Date lastVisit;
    private AtomicInteger hitCount = new AtomicInteger(0);

    @Id
    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getFirstVisit() {
        return firstVisit;
    }

    public void setFirstVisit(Date firstVisit) {
        this.firstVisit = firstVisit;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Integer getHits() {
        return hitCount.get();
    }

    public void setHits(Integer hits) {
        this.hitCount = new AtomicInteger(hits);
    }
    
    public int addHit() {
        return hitCount.incrementAndGet();
    }
}
