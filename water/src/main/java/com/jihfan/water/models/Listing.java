package com.jihfan.water.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Listing {
	// CONSTRUCTOR(S)
	public Listing() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	// JOINS
	//Vid 1 32:19
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}
	
	//36:40
	@OneToMany(mappedBy="listing",fetch=FetchType.LAZY)
	private List<Review> reviews;
	public void setReviews(List<Review> reviews){
		this.reviews = reviews;
	}
	public List<Review> getReviews(){
		return reviews;
	}

	
	// ATTRIBUTES
	@Id
	@GeneratedValue
	private long id;
	
	
	@Size(min = 1, max = 255, message = "Address is required.")
	private String address;
	
	@Size(min = 1, max = 1024, message = "Listing must have a short description.")
	private String description;
	
	@NotNull(message = "")
	private double cost;
	
	@Size(min = 1, max = 255, message = "Size is required.")
	private String size;
	
	@DateTimeFormat(pattern = "MM:dd:yyyy hh:mm")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "MM:dd:yyyy hh:mm")
	private Date updatedAt;
	
	@PrePersist
	public void onCreate() {this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate() {this.updatedAt = new Date();}
	
	private double average;
	public void setAverage(double average){
		this.average = average;
	}
	public double getAverage(){
		return average;
	}
	
	// GETTERS & SETTERS
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setCost(double cost) {
		this.cost  = cost;
	}
	public double getCost() {
		return cost;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	
	
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	

