package com.rpcherrera.ipalit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class Feedback {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String rating;
	
	@Size(min=10, message="Post an honest feedback brah.")
	@Column(name = "feedback_desc")
	private String feedbackDesc;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_posted")
	private Date datePosted;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Integer getId() {
		return id;
	}

	public String getRating() {
		return rating;
	}

	public String getFeedbackDesc() {
		return feedbackDesc;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public User getUser() {
		return user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setFeedbackDesc(String feedbackDesc) {
		this.feedbackDesc = feedbackDesc;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
