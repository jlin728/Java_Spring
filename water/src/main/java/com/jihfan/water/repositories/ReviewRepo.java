package com.jihfan.water.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jihfan.water.models.Review;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Long>{

}
