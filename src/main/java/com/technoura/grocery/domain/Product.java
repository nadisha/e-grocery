package com.technoura.grocery.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
import javax.persistence.Transient;

import com.technoura.grocery.domain.enums.Status;
import com.technoura.grocery.domain.enums.UnitType;

@Entity
@Table( name = "products")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 8222321588440534140L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String title;
	
	private String code;
	
	@Enumerated(EnumType.STRING)
	private UnitType unitType;
	
	private int unitSize;
	
	@Column(length = 3000)
	private String description;
	
	// ACTIVE and INACTIVE
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", foreignKey = @ForeignKey (foreignKeyDefinition = "fk_category_id", name="products_fk_category_id"))
	private Category category;

	@OneToMany(mappedBy = "product")
	private List<BillProduct> billProducts;
	
	@OneToMany(mappedBy = "product")
	private List<BillFreeIssue> billFreeIssues;
	
	@OneToMany(mappedBy = "product")
	private List<BillMarketReturn> billMarketReturns;
	
	@OneToMany(mappedBy = "product")
	private List<ProductPrice> productPrices;	
	
	@OneToMany(mappedBy = "product")
	private List<OrderProduct> orderProducts;	
	
	@OneToMany(mappedBy = "product")
	private List<Image> images;	
	
	@OneToMany(mappedBy = "product")
	private List<PromotionalProduct> promotionalProducts;	
	
	@Transient
	private ProductPrice price;	
	
	private int order;		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	public int getUnitSize() {
		return unitSize;
	}

	public void setUnitSize(int unitSize) {
		this.unitSize = unitSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<BillProduct> getBillProducts() {
		if (billProducts == null) {
			billProducts = new ArrayList<BillProduct>();
		}
		return billProducts;
	}

	public void setBillProducts(List<BillProduct> billProducts) {
		this.billProducts = billProducts;
	}

	public List<BillFreeIssue> getBillFreeIssues() {
		if (billFreeIssues == null) {
			billFreeIssues = new ArrayList<BillFreeIssue>();
		}
		return billFreeIssues;
	}

	public void setBillFreeIssues(List<BillFreeIssue> billFreeIssues) {
		this.billFreeIssues = billFreeIssues;
	}

	public List<BillMarketReturn> getBillMarketReturns() {
		if (billMarketReturns == null) {
			billMarketReturns = new ArrayList<BillMarketReturn>();
		}
		return billMarketReturns;
	}

	public void setBillMarketReturns(List<BillMarketReturn> billMarketReturns) {
		this.billMarketReturns = billMarketReturns;
	}

	public List<ProductPrice> getProductPrices() {
		if (productPrices == null) {
			productPrices = new ArrayList<ProductPrice>();
		}
		return productPrices;
	}

	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}

	public ProductPrice getPrice() {
		return price;
	}

	public void setPrice(ProductPrice price) {
		this.price = price;
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

	public List<Image> getImages() {
		if (images == null) {
			images = new ArrayList<>();
		}
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<PromotionalProduct> getPromotionalProducts() {
		if (promotionalProducts == null) {
			promotionalProducts = new ArrayList<>();
		}
		return promotionalProducts;
	}

	public void setPromotionalProducts(List<PromotionalProduct> promotionalProducts) {
		this.promotionalProducts = promotionalProducts;
	}
}
