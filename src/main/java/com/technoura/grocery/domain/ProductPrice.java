package com.technoura.grocery.domain;

import java.io.Serializable;

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
import javax.persistence.Table;

import com.technoura.grocery.domain.enums.Status;

@Entity
@Table(name = "product_prices")
public class ProductPrice implements Serializable {

	private static final long serialVersionUID = -870397742917995965L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	// Intermediator purchase price 
	@Column(name = "unit_purchase_price", nullable = true, scale = 2)
	private Float unitPurchasePrice;
	
	// Intermediator selling price to end customer (Retail price)
	@Column(name = "unit_selling_price", nullable = true, scale = 2)
	private Float unitSellingPrice;
	
	// Agency selling price of an unit to intermediator
	@Column(name = "agent_unit_selling_price", nullable = true, scale = 2)
	private Float agentUnitSellingPrice;
	
	// Supplier selling price of an unit to agent
	@Column(name = "agent_unit_purchase_price", nullable = true, scale = 2)
	private Float agentUnitPurchasePrice;	
	
	@Column(name = "minimum_saleable_units")
	private int minimumSaleableUnits;
	
	@Embedded
	private EntityLog entityLog;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", foreignKey = @ForeignKey (foreignKeyDefinition = "fk_product_id", name="product_prices_fk_product_id"))
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getUnitPurchasePrice() {
		return unitPurchasePrice;
	}

	public void setUnitPurchasePrice(Float unitPurchasePrice) {
		this.unitPurchasePrice = unitPurchasePrice;
	}

	public Float getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public void setUnitSellingPrice(Float unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public EntityLog getEntityLog() {
		return entityLog;
	}

	public void setEntityLog(EntityLog entityLog) {
		this.entityLog = entityLog;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getAgentUnitSellingPrice() {
		return agentUnitSellingPrice;
	}

	public void setAgentUnitSellingPrice(Float agentUnitSellingPrice) {
		this.agentUnitSellingPrice = agentUnitSellingPrice;
	}

	public Float getAgentUnitPurchasePrice() {
		return agentUnitPurchasePrice;
	}

	public void setAgentUnitPurchasePrice(Float agentUnitPurchasePrice) {
		this.agentUnitPurchasePrice = agentUnitPurchasePrice;
	}

	public int getMinimumSaleableUnits() {
		return minimumSaleableUnits;
	}

	public void setMinimumSaleableUnits(int minimumSaleableUnits) {
		this.minimumSaleableUnits = minimumSaleableUnits;
	}
}
