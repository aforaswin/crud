package com.app.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.product.entities.Promotion;

@Repository
public interface PromotionServiceRepository extends JpaRepository<Promotion, String> {

}
