package com.lissenberg.blog.domain;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Statistics {
	private Long blogId;
	private Date firstVisit;
	private Date lastVisit;
	private AtomicInteger hits;

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
