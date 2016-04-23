package com.programmunity.webapplication.models;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * Post on the website. Ex: Tweet
 * 
 * @author Basheer
 *
 */
public class Feed
{

	// TODO: Verify hibernate
		@GenericGenerator(name = "generator", strategy = "identity")
		@GeneratedValue(generator = "generator")
	private long feedId;
	/**
	 * User who posted the feed
	 */
	@NotNull
	private User poster;

	/**
	 * The post
	 */
	@NotNull
	@Size(max = 500)
	private String post;

	/**
	 * If the post links to another post
	 */
	private Feed repost;

	/**
	 * How many likes the psot has
	 */
	@Size(max = 10000)
	private int likes;

	/**
	 * @return the poster
	 */
	public User getPoster()
	{
		return poster;
	}

	/**
	 * @param poster
	 *            the poster to set
	 */
	public void setPoster(User poster)
	{
		this.poster = poster;
	}

	/**
	 * @return the post
	 */
	public String getPost()
	{
		return post;
	}

	/**
	 * @param post
	 *            the post to set
	 */
	public void setPost(String post)
	{
		this.post = post;
	}

	/**
	 * @return the repost
	 */
	public Feed getRepost()
	{
		return repost;
	}

	/**
	 * @param repost
	 *            the repost to set
	 */
	public void setRepost(Feed repost)
	{
		this.repost = repost;
	}

	/**
	 * @return the likes
	 */
	public int getLikes()
	{
		return likes;
	}

	/**
	 * @param likes
	 *            the likes to set
	 */
	public void setLikes(int likes)
	{
		this.likes = likes;
	}

}
