package com.jihfan.products.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Table(name = "product")

public class Product {

	// PRIVATE ATTRIBUTES

	@Id				
	@GeneratedValue	

	@Column
	private long id;

	@Column
	@Size(min = 1, max = 255, message = "Name cannot be blank")
	String name;

	@Column
	@Size(min = 3, max = 255, message = "Please enter description")
	String description;

	@Column
	double price;

	@Column
	@DateTimeFormat(pattern = "MM:dd:yyy HH:mm:ss")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern = "MM:dd:yyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate() {this.createdAt = new Date();}

	@PreUpdate
	public void onUpdate() {this.updatedAt = new Date();}

	// PUBLIC METHODS		Setters and Getters below

	public void setName (String name) {	
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice (double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

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

	// ----------------------------------------------------------------------------------------------------
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "products_categories",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")		
	)
	private List<Category> categories;

	public void setCategories(List<Category> categories) {
		this.categories= categories;
	}
	public List<Category> getCategories(){
		return categories;
	}
	// ----------------------------------------------------------------------------------------------------

	public Product() {
		this.createdAt = new Date ();
		this.updatedAt = new Date ();

	}
}
