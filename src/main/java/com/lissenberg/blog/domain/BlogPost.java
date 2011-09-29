package com.lissenberg.blog.domain;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "blog_post")
public class BlogPost {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Temporal(TemporalType.TIMESTAMP)
	private Date posted = new Date();
	private String title;
	private String text;

    @ManyToOne
    @JoinColumn(name="user_id")
	private User author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
}
