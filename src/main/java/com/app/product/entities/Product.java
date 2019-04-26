package com.app.product.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "PRODUCT_ID")
	private String id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE_ID")
	private String typeId;
	
	
	private String priceId;

	private String promotionId;

	private String invetoryId;

	public Product() {
	}

	public Product(String name, String typeId, String priceId, String promotionId, String invetoryId) {
		this.name = name;
		this.typeId = typeId;
		this.priceId = priceId;
		this.promotionId = promotionId;
		this.invetoryId = invetoryId;
	}

	public Product(String id, String name, String typeId, String priceId, String promotionId, String invetoryId) {
		this.id = id;
		this.name = name;
		this.typeId = typeId;
		this.priceId = priceId;
		this.promotionId = promotionId;
		this.invetoryId = invetoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public String getInvetoryId() {
		return invetoryId;
	}

	public void setInvetoryId(String invetoryId) {
		this.invetoryId = invetoryId;
	}
}
