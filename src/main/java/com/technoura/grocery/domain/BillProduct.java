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
@Table(name = "bill_products")
public class BillProduct implements Serializable {

	private static final long serialVersionUID = -3086320566103332443L;

	@Id
	private BillProductPK billProductPK = new BillProductPK();
	
	@ManyToOne
	@JoinColumn(name = "bill_id",  nullable = false, updatable = false, insertable = false)	
	private Bill bill;
	
	@ManyToOne
	@JoinColumn(name = "product_id",  nullable = false, updatable = false, insertable = false)	
	private Product product;
	
	@Column(name = "selling_packages")
	private int sellingPackages;
	
	@Column(name = "selling_packets")
	private int sellingPackets;
	
	@Column(name = "total_selling_price", nullable = true, scale = 2)
	private Float totalSellingPrice;
	
	@Column(name = "packet_selling_price", nullable = true, scale = 2)
	private Float packetSellingPrice;
	
	@Column(name = "discount_percentage", nullable = true, scale = 2)
	private Float discountPercentage;
	
	@Column(name = "discount_amount", nullable = true, scale = 2)
	private Float discountAmount;	
	
	@Column(nullable = true, scale = 2)
	private Float profit;

	public int getSellingPackages() {
		return sellingPackages;
	}

	public void setSellingPackages(int sellingPackages) {
		this.sellingPackages = sellingPackages;
	}

	public int getSellingPackets() {
		return sellingPackets;
	}

	public void setSellingPackets(int sellingPackets) {
		this.sellingPackets = sellingPackets;
	}

	public Float getTotalSellingPrice() {
		return totalSellingPrice;
	}

	public void setTotalSellingPrice(Float totalSellingPrice) {
		this.totalSellingPrice = totalSellingPrice;
	}

	public Float getPacketSellingPrice() {
		return packetSellingPrice;
	}

	public void setPacketSellingPrice(Float packetSellingPrice) {
		this.packetSellingPrice = packetSellingPrice;
	}

	public Float getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Float getProfit() {
		return profit;
	}

	public void setProfit(Float profit) {
		this.profit = profit;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		if (bill != null) {
			this.billProductPK.setBill(bill.getId());
		}
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		if (product != null) {
			this.billProductPK.setProduct(product.getId());
		}
		this.product = product;
	}
}

@Embeddable
class BillProductPK implements Serializable{

	private static final long serialVersionUID = 3768491855617387723L;

	@SuppressWarnings("unused")
	@Column(name = "bill_id", nullable = false, updatable = false, insertable = false)	
	private Long bill;
	
	@SuppressWarnings("unused")
	@Column(name = "product_id", nullable = false, updatable = false, insertable = false)
	private Long product;

	public Long getBill() {
		return bill;
	}

	public void setBill(Long bill) {
		this.bill = bill;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}
}