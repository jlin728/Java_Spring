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
//import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity	
//@Table(name = "product")

public class Product {												

	// PRIVATE ATTRIBUTES
	
	@Id																// creates id
	@GeneratedValue													// auto-generated
	private long id;												
	
	@Size(min = 1, max = 255, message = "Name cannot be blank")		// 2) Validations
	String name;													// 1) set attributes
	
	@Size(min = 3, max = 1024, message = "Please enter description")
	String desc;
	
	@Min(0)														//@NotNull just means it cannot be blank.
	double price;
	
	// PUBLIC METHODS		Setters and Getters below
	
	public void setName (String name) {								// 3) Getters and Setters to access private attributes
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDesc (String desc) {								
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setPrice (double price) {							
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	// ----------------------------------------------------------------------------------------------------
	@ManyToMany(fetch = FetchType.LAZY)									// 5) MUST SET RELATIONSHIP HERE!!!
	@JoinTable(
			name = "products",
			joinColumns = @JoinColumn(name = "product_id"),				// Hint - look at class. Self table
			inverseJoinColumns = @JoinColumn(name = "category_id")		//		- this will the the other table you want to join at.
	)
	private List<Category> categories;

	public void setCategories(List<Category> categories) {				// 6) Add setters/getters
		this.categories= categories;
	}
	public List<Category> getCategories(){
		return categories;
	}
	// ----------------------------------------------------------------------------------------------------
	
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
	
	public Product() {									// 4) Create blank constructor
		this.createdAt = new Date ();
		this.updatedAt = new Date ();
	}
	
//	public Product (String name, String desc, double price) {
//		super();
//		this.name = name;
//		this.desc = desc;
//		this.price = price;
//	}
	
	
	
}
