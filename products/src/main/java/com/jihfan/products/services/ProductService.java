package com.jihfan.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jihfan.products.models.Product;
import com.jihfan.products.repositories.ProductRepo;

@Service
public class ProductService {
	private ProductRepo pR;
	
	public ProductService(ProductRepo pR) {
		this.pR = pR;
	}
	
	public void create(Product product) {
		pR.save(product);
	}
	
	public List<Product> allProducts(){
		return (List<Product>) pR.findAll();	
	}
	
//	public Product find(Long id) {
//	return pR.findById(id).get();
//}
	
	// option 2
//	public Product getById(Long id) {
//		return pR.findById(id).orElse(null);
//	}
	
	public Optional<Product> find(Long id) {
		return pR.findById(id);
	}
	
	public void destroy(Product product) {
		pR.delete(product);
	}

}
