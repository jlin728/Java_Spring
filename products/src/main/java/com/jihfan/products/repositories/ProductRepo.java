package com.jihfan.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jihfan.products.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{

}
