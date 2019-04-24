package com.app.product.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.entities.Promotion;
import com.app.product.services.PromotionService;

@RestController
public class PromotionResource {
	@Autowired
	private PromotionService  promotionService;
	
	@RequestMapping(path = "/v1/promotions", method = RequestMethod.POST)
	public ResponseEntity<Promotion> addPromotion(@RequestBody final Promotion promotion){
		return ResponseEntity.ok().body(promotionService.add(promotion));
		
	}
	
	@RequestMapping(path = "/v1/promotions/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Promotion> deletePromotion(@PathVariable final String id){
		return ResponseEntity.ok().body(promotionService.delete(id));
		
	}

}
