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
public class Review {

	// CONSTRUCTOR(S)
	public Review() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	// ATTRIBUTES
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
		
	@Size(min = 1, max = 1024, message = "Description is required.")
	private String description;
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}	
	
	@NotNull
	private int rating;
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRating() {
		return rating;
	}
	
	
	@DateTimeFormat(pattern = "MM:dd:yyyy hh:mm")
	private Date createdAt;
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	@PrePersist
	public void onCreate() {this.createdAt = new Date();}
	
	
	@DateTimeFormat(pattern = "MM:dd:yyyy hh:mm")
	private Date updatedAt;	
	@PreUpdate
	public void onUpdate() {this.updatedAt = new Date();}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public User user() {
		return user;
	}	
	

	//-------------------------------------------------------------------------------------------------
	
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="listing_id")
		private Listing listing;
		public void setListing(Listing listing){
			this.listing = listing;
		}
		public Listing getListing(){
			return listing;
		}

		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;

		public void setUser(User user){
			this.user=user;
		}
		public User getUser(){
			return user;
		}
		
		//-------------------------------------------------------------------------------------------------


	
	
	
	


	
}
