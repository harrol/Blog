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
@Entity(name = "blog_comment")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long blogId;
    @Column(length = 500)
    private String text;
    private String name;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date posted;


    public Comment() {
        // required for JPA
    }

    public Comment(Long blogId, String name, String text) {
        this.blogId = blogId;
        this.text = text;
        this.name = name;
        posted = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", text='" + text + '\'' +
                ", name='" + name + '\'' +
                ", posted=" + posted +
                '}';
    }
}
