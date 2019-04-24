package com.app.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.product.entities.Product;

@Repository
public interface ProductServiceRepository extends JpaRepository<Product, String> {

}
