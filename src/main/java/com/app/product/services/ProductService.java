package com.app.product.services;

import java.util.List;

import com.app.product.entities.Product;

public interface ProductService {
	
	Product add(Product product);
	
	List<Product> getAllProducts();
	
	Product delete(final String id);
	
	Product getProduct(final String id);

	Product update(Product product);

}
