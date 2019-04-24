package com.app.product.services;

import com.app.product.entities.Promotion;

public interface PromotionService {
	
	Promotion add(Promotion promotion);
	
	Promotion delete(final String id);

}
