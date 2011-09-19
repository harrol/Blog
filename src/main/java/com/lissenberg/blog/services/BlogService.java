package com.lissenberg.blog.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;

import com.lissenberg.blog.domain.BlogPost;
import com.lissenberg.blog.domain.User;


@Singleton
@Named
public class BlogService {

	private List<BlogPost> posts;

	@PostConstruct
	public void init() {
		posts = new ArrayList<BlogPost>();
		User harro = new User();
		harro.setId(1L);
		harro.setName("Harro Lissenberg");
		harro.setUsername("harro");
		BlogPost post = new BlogPost();
		post.setId(1L);
		post.setAuthor(harro);
		post.setTitle("What on earth is this???");
		post.setText("Java EE 6 is well over a year old and I never got the change to work with it in a " +
				"profession environment. All current projects my company runs still use old and trusted frameworks.<br/>" +
				"I decided to take matters into my own hands and started this quest to learn Java EE 6." +
				" Wanting to do a little bit more than just a Hello World application and decided to build" +
				" blogging software using nothing but plain vanilla Java EE 6 (and perhaps a JSF component library)" +
				" and at the same time use it to blog about my adventures.<br/>" +
				"Over time more and more features should be implemented that turn this site into a decent blog.<br/><br/>" +
				"It starts now...");
		posts.add(post);

	}

	/**
	 * Returns a list of blog posts ordered by date. Newest first.
	 *
	 * @param maxPosts
	 * 		the amount of post to return.
	 *
	 * @return a list of blog posts
	 */
	public List<BlogPost> getLatestPosts(int maxPosts) {
		return posts;
	}


	/**
	 * Add a new blogpost
	 * @param post the post to add
	 */
	public void addPost(BlogPost post) {
		posts.add(post);
	}


}
