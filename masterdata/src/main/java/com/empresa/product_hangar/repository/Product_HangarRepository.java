package com.empresa.product_hangar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.product_hangar.model.Product_Hangar;

@Repository
public interface Product_HangarRepository  extends JpaRepository<Product_Hangar, Long>{

}
