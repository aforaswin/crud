package com.app.product.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.product.entities.Promotion;
import com.app.product.repos.PromotionServiceRepository;
import com.app.product.services.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private PromotionServiceRepository promotionServiceRepository;
	
	@Override
	@Transactional
	public Promotion add(Promotion promotion) {
		return promotionServiceRepository.save(promotion);
	}

	@Override
	@Transactional
	public Promotion delete(String id) {
		final Optional<Promotion> promotion = promotionServiceRepository.findById(id);
		promotionServiceRepository.deleteById(id);
		return promotion.get();
	}

}
