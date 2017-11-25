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
@Table(name = "order_products")
public class OrderProduct implements Serializable {

	private static final long serialVersionUID = -1857511051086239162L;

	@Id
	private OrderProductPK orderProductPk = new OrderProductPK();
	
	@ManyToOne
	@JoinColumn(name = "order_id",  nullable = false, updatable = false, insertable = false)	
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id",  nullable = false, updatable = false, insertable = false)	
	private Product product;	
	
	@Column(nullable = true)
	private Integer quantity;
	
	@Column(name = "unit_price", nullable = true)
	private Float unitPrice;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if (order != null) {
			this.orderProductPk.setOrder(order.getId());
		}
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		if (product != null) {
			this.orderProductPk.setProduct(product.getId());
		}
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}	
}

@Embeddable
class OrderProductPK implements Serializable {

	private static final long serialVersionUID = -1136347695215430317L;

	@SuppressWarnings("unused")
	@Column(name = "order_id", nullable = false, updatable = false, insertable = false)		
	private Long order;
	
	@SuppressWarnings("unused")
	@Column(name = "product_id", nullable = false, updatable = false, insertable = false)	
	private Long product;

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}
}