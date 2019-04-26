package com.app.product.services.impl;

import com.app.product.entities.Product;
import com.app.product.repos.ProductServiceRepository;
import com.app.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductServiceRepository productServiceRepository;


	@Override
	@Transactional
	public Product add(Product product) {
		return productServiceRepository.save(product);
	}

	@Override
	@Transactional
	public Product delete(String id) {
		Optional<Product> optProduct = productServiceRepository.findById(id);
		if(!optProduct.isPresent()) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		Product product = optProduct.get();
		productServiceRepository.delete(product);
		return product;
	}

	@Override
	@Transactional
	public Product update(Product product) {

		Optional<Product> optProduct = productServiceRepository.findById(product.getId());
		if(!optProduct.isPresent()) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		productServiceRepository.save(product);
		return product;
	}

	@Override
	@Transactional
	public Product getProduct(String id) {
		Optional<Product> optProduct = productServiceRepository.findById(id);
		if(!optProduct.isPresent()) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		return optProduct.get();

	}

	@Override
	public List<Product> getAllProducts() {
		return productServiceRepository.findAll();
	}

}
