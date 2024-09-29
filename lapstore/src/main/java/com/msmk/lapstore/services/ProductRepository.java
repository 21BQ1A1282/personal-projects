package com.msmk.lapstore.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.msmk.lapstore.models.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
}
