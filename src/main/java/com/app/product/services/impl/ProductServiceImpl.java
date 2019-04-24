package com.app.product.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.product.entities.Product;
import com.app.product.repos.ProductServiceRepository;
import com.app.product.repos.PromotionServiceRepository;
import com.app.product.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductServiceRepository productServiceRepository;
	
	private PromotionServiceRepository promotionServiceRepository;

	@Override
	@Transactional
	public Product add(Product product) {
		if(product.getPromotion()!=null){
			promotionServiceRepository.findById(product.getPromotion().getId());
		}
		return productServiceRepository.save(product);
	}

	@Override
	@Transactional
	public Product delete(String id) {
		Product product = productServiceRepository.findById(id).get();
		productServiceRepository.delete(product);
		return product;
	}

	@Override
	@Transactional
	public Product getProduct(String id) {
		return productServiceRepository.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		return productServiceRepository.findAll();
	}

}
