package com.jihfan.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jihfan.products.models.Category;

@Repository
public interface CatRepo extends CrudRepository<Category, Long>{

}

