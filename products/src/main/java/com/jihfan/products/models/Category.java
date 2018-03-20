package com.jihfan.products.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Category {										

	// PRIVATE ATTRIBUTES
	
	@Id														
	@GeneratedValue											
	private long id;												
	
	@Size(min = 1, max = 255, message = "Category cannot be blank")		// 2) Validations
	String name;								// 1) set attributes
	
	// PUBLIC METHODS		Setters and Getters below
	
	public void setName (String name) {					// 3) Getters and Setters
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// COPY BELOW TO PRODUCT MODEL and swap joincolumns and List <name>
	@ManyToMany(fetch = FetchType.LAZY)						// 4) MUST SET RELATIONSHIP HERE!!!
	@JoinTable(
			name = "products_categories",
			joinColumns = @JoinColumn(name = "category_id"),		// Hint - look at class. 
			inverseJoinColumns = @JoinColumn(name = "product_id")		//- this will the the other table you want to join at.
	)
	private List<Product> products;
	
	public void setProducts (List<Product> products) {				// 6) add getters and setters
		this.products = products;
	}
	public List<Product> getProducts(){
		return products;
	}
	
	@DateTimeFormat(pattern = "MM:dd:yyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "MM:dd:yyy HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	public void onCreate() {this.createdAt = new Date();}
	
	@PreUpdate
	public void onUpdate() {this.updatedAt = new Date();}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
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
	
	public Category () {									// 5) Create blank constructor
		this.createdAt = new Date ();
		this.updatedAt = new Date ();
	}

	
	
}
