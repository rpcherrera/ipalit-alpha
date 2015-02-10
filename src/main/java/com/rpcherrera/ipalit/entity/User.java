package com.rpcherrera.ipalit.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;





import org.hibernate.validator.constraints.Email;


import org.springframework.format.annotation.DateTimeFormat;

import com.rpcherrera.ipalit.annotation.UniqueEmail;
import com.rpcherrera.ipalit.annotation.UniqueUsername;


@Entity
@Table(name= "app_user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, message="First name must be at	least 3 characters!")
	private String name;
	
	@Size(min=3, message="Last name must be at least 3 characters!")
	private String lname;
	
	@Size(min=3, message="Username must be at least 4 characters!")
	@Column(unique = true)
	@UniqueUsername(message="Such username already exists!")
	private String username;
	
	@Size(min=1, message="Invalid email format!")
	@Email(message="Invalid email format!")
	@UniqueEmail(message="This email is already registered")
	private String email;
	
	@Size(min=6, message="Password must be at least 6 characters!")
	private String password;
	
	@Size(min=11, max=11, message="Cellular number must be exactly 11 digits!")
	private String contactnum;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Blog> blogs;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Wishlist> wish;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private List<Feedback> feedbacks;
	
	private boolean enabledEh;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="date_joined")
	private Date dateJoined;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLname() {
		return lname;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getContactnum() {
		return contactnum;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public List<Wishlist> getWish() {
		return wish;
	}

	public boolean isEnabledEh() {
		return enabledEh;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContactnum(String contactnum) {
		this.contactnum = contactnum;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public void setWish(List<Wishlist> wish) {
		this.wish = wish;
	}

	public void setEnabledEh(boolean enabledEh) {
		this.enabledEh = enabledEh;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
}
