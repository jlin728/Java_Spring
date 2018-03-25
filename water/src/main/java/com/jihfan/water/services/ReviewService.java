package com.jihfan.water.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jihfan.water.models.Review;
import com.jihfan.water.repositories.ReviewRepo;

@Service
public class ReviewService {
	private ReviewRepo rR;
	
	public ReviewService (ReviewRepo rR) {
		this.rR = rR;
	}
	
	public void create(Review review) {
		rR.save(review);
	}
	
	public Review find(Long id) {
		return (Review)rR.findById(id).orElse(null);
	}
	
	public ArrayList<Review> all(){
		return (ArrayList<Review>)rR.findAll();
	}
	
	public void update(Review review) {
		rR.save(review);
	}
	
	public void destroy(Long id) {
		rR.deleteById(id);
	}
	
	
}
