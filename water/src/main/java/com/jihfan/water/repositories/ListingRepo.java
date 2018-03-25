package com.jihfan.water.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jihfan.water.models.Listing;

@Repository
public interface ListingRepo extends CrudRepository<Listing, Long>{
	public List<Listing> findByAddress(String address);
}
