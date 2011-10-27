package com.lissenberg.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author Harro Lissenberg
 */
@Entity(name = "blog_req_info")
public class RequestInfo {

    private static final int MAX_REFERER_LENGTH = 200;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date visit;

    private Long blogId;

    @Column(length = MAX_REFERER_LENGTH)
    private String referer;
    private String userAgent;

    public RequestInfo(Long blogId, String referer, String userAgent) {
        this.blogId = blogId;
        this.referer = referer;
        this.userAgent = userAgent;
        this.visit = new Date();
    }

    public RequestInfo() {
        // required for JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisit() {
        return visit;
    }

    public void setVisit(Date visit) {
        this.visit = visit;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        // Quick fixing a problem with referers too long for the database that crash the application
        if(referer != null && referer.length() > MAX_REFERER_LENGTH) {
            this.referer = referer.substring(0, MAX_REFERER_LENGTH);
        } else {
            this.referer = referer;
        }
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "RequestInfo{" + "id=" + id + ", visit=" + visit + ", blogId=" + blogId + ", referer=" + referer + ", userAgent=" + userAgent + '}';
    }


}
