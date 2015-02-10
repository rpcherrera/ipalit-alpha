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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Wishlist {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=1, message="This item must have a name")
	@Column(name = "wishlist_name")
	private String wishlistName;
	
	@Size(min=10, message="Please put an accurate description of your item")
	@Column(name = "wishlist_desc")
	private String wishlistDesc;
	
	@DateTimeFormat(pattern="mm:hh dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_posted")
	private Date datePosted;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public int getId() {
		return id;
	}

	public String getWishlistName() {
		return wishlistName;
	}

	public String getWishlistDesc() {
		return wishlistDesc;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public User getUser() {
		return user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setWishlistName(String wishlistName) {
		this.wishlistName = wishlistName;
	}

	public void setWishlistDesc(String wishlistDesc) {
		this.wishlistDesc = wishlistDesc;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
