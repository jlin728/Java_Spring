package com.jihfan.water.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jihfan.water.models.Listing;
import com.jihfan.water.repositories.ListingRepo;



@Service
public class ListingService {
	private ListingRepo lR;
	
	public ListingService(ListingRepo lR) {
		this.lR = lR;
	}
	
	public void create(Listing listing) {
		lR.save(listing);
	}
	
	public Listing find(Long id) {
		return (Listing) lR.findById(id).orElse(null);
	}
	
	public ArrayList<Listing> all(){
		return (ArrayList<Listing>)lR.findAll();
	}
	
	public void update(Listing listing) {
		lR.save(listing);
	}
	
	public void destroy(Long id) {
		lR.deleteById(id);
	}
	
	public ArrayList<Listing> findByAddress(String address){
		return (ArrayList<Listing>)lR.findByAddress(address);
	}
	
}
