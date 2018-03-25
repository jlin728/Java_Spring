package com.jihfan.water.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import com.jihfan.water.models.Listing;


@Entity
public class User {
	
	// CONSTRUCTOR(S)
	public User() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	// ATTRIBUTES
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min = 1, max = 255, message = "First name cannot be blank!")
	private String firstName;
	
	@Size(min = 1, max = 255, message = "Last name cannot be blank!")
	private String lastName;
	
	@Email(message = "Invalid email! Ex: example@somemail.com")
	private String email;
	
	@Size(min = 6, max = 255, message = "Password must be between 6 - 255 characters!")
	private String password;
	
	@DateTimeFormat(pattern = "MM:dd:yyyy hh:mm")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "MM:dd:yyyy hh:mm")
	private Date updatedAt;
	
	@PrePersist
	public void onCreate() {this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate() {this.updatedAt = new Date();}
	
	private boolean host;
	
	// GETTERS & SETTERS
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public void setHost(boolean host) {
		this.host = host;
	}
	public boolean isHost() {
		return host;
	}
	
	//-------------------------------------------------------------------------------------------------
	
	//Vid1 25:43
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private List<Listing> listings;
	public void setListings(List<Listing> listings){
		this.listings=listings;
	}
	public List<Listing> getListings(){
		return listings;
	}

	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private List<Review> reviews;
	public void setReviews(List<Review> reviews){
		this.reviews = reviews;
	}
	public List<Review> getReviews(){
		return reviews;
	}

	
	
	
	
}
