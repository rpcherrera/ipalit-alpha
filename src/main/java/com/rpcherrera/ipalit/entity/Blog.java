package com.rpcherrera.ipalit.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
public class Blog {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=1, message="YYOYOYO")
	private String url;
	
	@Size(min=1, message="This item must have a name")
	private String name;
	
	@Size(min=1, message="This item must have a name")
	@Column(name="item_name")
	private String itemname;
	
	@Size(min=10, message="Please put an accurate description of your item")
	@Column(name="item_desc")
	private String itemdescription;
	
	@DateTimeFormat(pattern="mm:hh dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_posted")
	private Date datePosted;
	
	@Column(name="item_condition")
	private String itemCondition;
	
	private String warranty;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="blog", cascade=CascadeType.REMOVE)
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

	public String getItemname() {
		return itemname;
	}
	
	public String getItemname2() {
		return itemname.toLowerCase();
	}

	public String getItemdescription() {
		return itemdescription;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

}
