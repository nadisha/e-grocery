package com.technoura.grocery.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderPrice implements Serializable {

	private static final long serialVersionUID = -1070076060637132232L;

	@Column(name = "delivery_fee", nullable = true)
	private Float deliveryFee;
	
	@Column(name = "order_products_total", nullable = true)
	private Float orderProductsTotal;
	
	@Column(name = "final_amount", nullable = true)
	private Float finalAmount;

	public Float getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(Float deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public Float getOrderProductsTotal() {
		return orderProductsTotal;
	}

	public void setOrderProductsTotal(Float orderProductsTotal) {
		this.orderProductsTotal = orderProductsTotal;
	}

	public Float getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Float finalAmount) {
		this.finalAmount = finalAmount;
	}
}
