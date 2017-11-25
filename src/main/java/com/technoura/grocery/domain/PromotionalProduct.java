package com.technoura.grocery.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "promotional_products")
public class PromotionalProduct implements Serializable {

	private static final long serialVersionUID = 6525015325616056090L;

	@Id
	private PromotionalProductPK promotionalProductPK = new PromotionalProductPK();
	
	@ManyToOne
	@JoinColumn(name = "promotion_id",  nullable = false, updatable = false, insertable = false)	
	private Promotion promotion;
	
	@ManyToOne
	@JoinColumn(name = "product_id",  nullable = false, updatable = false, insertable = false)	
	private Product product;
	
	@Column(name = "promotional_price", nullable = true, scale = 2)
	private Float promotionalPrice;
	
	@Column(name = "minimum_saleable_units")
	private int minimumSaleableUnits;
	
	@Column(name = "free_units")
	private int freeUnits;

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		if (promotion != null) {
			this.promotionalProductPK.setPromotion(promotion.getId());
		}
		this.promotion = promotion;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		if (product != null) {
			this.promotionalProductPK.setProduct(product.getId());
		}
		this.product = product;
	}

	public Float getPromotionalPrice() {
		return promotionalPrice;
	}

	public void setPromotionalPrice(Float promotionalPrice) {
		this.promotionalPrice = promotionalPrice;
	}

	public int getMinimumSaleableUnits() {
		return minimumSaleableUnits;
	}

	public void setMinimumSaleableUnits(int minimumSaleableUnits) {
		this.minimumSaleableUnits = minimumSaleableUnits;
	}

	public int getFreeUnits() {
		return freeUnits;
	}

	public void setFreeUnits(int freeUnits) {
		this.freeUnits = freeUnits;
	}
}

@Embeddable
class PromotionalProductPK implements Serializable{

	private static final long serialVersionUID = -4492475214488091288L;

	@SuppressWarnings("unused")
	@Column(name = "promotion_id", nullable = false, updatable = false, insertable = false)	
	private Long promotion;
	
	@SuppressWarnings("unused")
	@Column(name = "product_id", nullable = false, updatable = false, insertable = false)
	private Long product;

	public Long getPromotion() {
		return promotion;
	}

	public void setPromotion(Long promotion) {
		this.promotion = promotion;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}
}