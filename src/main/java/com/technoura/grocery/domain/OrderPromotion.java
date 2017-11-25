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
@Table( name = "order_promotions")
public class OrderPromotion implements Serializable {

	private static final long serialVersionUID = -5154780041481023387L;

	@Id
	private OrderPromotionPK orderPromotionPK = new OrderPromotionPK();
	
	@ManyToOne
	@JoinColumn(name = "promotion_id",  nullable = false, updatable = false, insertable = false)	
	private Promotion promotion;
	
	@ManyToOne
	@JoinColumn(name = "order_id",  nullable = false, updatable = false, insertable = false)	
	private Order order;

	@Column(nullable = true)
	private Integer quantity;
	
	@Column(name = "promotional_unit_price", nullable = true)
	private Float promotionalUnitPrice;

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		if (promotion != null) {
			this.orderPromotionPK.setPromotion(promotion.getId());
		}
		this.promotion = promotion;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if (order != null) {
			this.orderPromotionPK.setOrder(order.getId());
		}
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPromotionalUnitPrice() {
		return promotionalUnitPrice;
	}

	public void setPromotionalUnitPrice(Float promotionalUnitPrice) {
		this.promotionalUnitPrice = promotionalUnitPrice;
	}	
}

@Embeddable
class OrderPromotionPK implements Serializable {

	private static final long serialVersionUID = -5366815167507689877L;

	@SuppressWarnings("unused")
	@Column(name = "order_id", nullable = false, updatable = false, insertable = false)	
	private Long order;
	
	@SuppressWarnings("unused")
	@Column(name = "promotion_id", nullable = false, updatable = false, insertable = false)
	private Long promotion;

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public Long getPromotion() {
		return promotion;
	}

	public void setPromotion(Long promotion) {
		this.promotion = promotion;
	}	
}