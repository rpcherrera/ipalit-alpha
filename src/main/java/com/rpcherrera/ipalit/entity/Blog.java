package com.rpcherrera.ipalit.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Blog {

	@Id
	@GeneratedValue
	private int id;
	
	private String url;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="blog")
	private List<Item> items;

	public int getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
