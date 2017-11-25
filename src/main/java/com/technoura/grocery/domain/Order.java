package com.technoura.grocery.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.technoura.grocery.domain.enums.OrderStatus;
import com.technoura.grocery.domain.enums.OrderType;
import com.technoura.grocery.domain.enums.PaymentStatus;
import com.technoura.grocery.domain.enums.PaymentType;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -7720930655304697411L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name = "order_number")
	private String orderNumber;
	
	@Column(name = "delivery_date")
	private Date deliveryDate;
	
	@Embedded
	private Contact deliveryLocation;
	
	@Embedded
	private OrderPrice orderPrice;
	
	@Embedded
	private EntityLog entityLog;
	
	@Column(name = "delivery_note")
	private String deliveryNote;
	
	@Column(name = "payment_type")
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	@Column(name = "order_status")
	@Enumerated(EnumType.STRING)	
	private OrderStatus orderStatus;

	@Column(name = "payment_status")
	@Enumerated(EnumType.STRING)		
	private PaymentStatus paymentStatus;
	
	@Enumerated(EnumType.STRING)
	private OrderType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", foreignKey = @ForeignKey(foreignKeyDefinition = "fk_orders_customer_id"))	
	private User customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver_id", foreignKey = @ForeignKey(foreignKeyDefinition = "fk_orders_driver_id"))	
	private User driver;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderProduct> orderProducts;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderPromotion> orderPromotions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Contact getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(Contact deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public OrderPrice getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(OrderPrice orderPrice) {
		this.orderPrice = orderPrice;
	}

	public EntityLog getEntityLog() {
		return entityLog;
	}

	public void setEntityLog(EntityLog entityLog) {
		this.entityLog = entityLog;
	}

	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public User getDriver() {
		return driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}

	public List<OrderProduct> getOrderProducts() {
		if (orderProducts == null) {
			orderProducts = new ArrayList<>();
		}
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public List<OrderPromotion> getOrderPromotions() {
		if (orderPromotions == null) {
			orderPromotions = new ArrayList<>();
		}
		return orderPromotions;
	}

	public void setOrderPromotions(List<OrderPromotion> orderPromotions) {
		this.orderPromotions = orderPromotions;
	}
}
