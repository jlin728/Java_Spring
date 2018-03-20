package com.jihfan.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jihfan.products.models.Category;
import com.jihfan.products.repositories.CatRepo;


@Service
public class CatService {
	private CatRepo cR;
	
	public CatService(CatRepo cR) {
		this.cR = cR;
	}
	
	public void create(Category cat) {
		cR.save(cat);
	}
	
	public List<Category> allCat(){
		return (List<Category>) cR.findAll();	
	}
	
//	public Category find(Long id) {
//		return cR.findById(id).orElse(null);
//	}
	
	public Optional<Category> find(Long id) {
		return cR.findById(id);
	}
	
	public void destroy(Category cat) {
		cR.delete(cat);
	}

}
