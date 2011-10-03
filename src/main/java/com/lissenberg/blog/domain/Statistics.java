package com.lissenberg.blog.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Holds statistics for a blog post
 *
 * @author Harro Lissenberg
 */
@Entity
public class Statistics {

    @Id
    private Long blogId;
    private Date firstVisit;
    private Date lastVisit;
    private AtomicInteger hits;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long id) {
        this.blogId = id;
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

    public void setHits(int hits) {
        this.hits = new AtomicInteger(hits);
    }

    public int getHits() {
        return hits.get();
    }

    public void addHit() {
        hits.incrementAndGet();
    }
}
