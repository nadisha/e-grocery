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
@Table(name = "bill_free_issues")
public class BillFreeIssue implements Serializable {

	private static final long serialVersionUID = 7278631112682836848L;

	@Id
	private BillFreeIssuePK billFreeIssuePK = new BillFreeIssuePK();
	
	@ManyToOne
	@JoinColumn(name = "bill_id",  nullable = false, updatable = false, insertable = false)	
	private Bill bill;
	
	@ManyToOne
	@JoinColumn(name = "product_id",  nullable = false, updatable = false, insertable = false)	
	private Product product;
	
	@Column(name = "free_packages")
	private int freePackages;
	
	@Column(name = "free_packets")
	private int freePackets;

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		if (bill != null) {
			this.billFreeIssuePK.setBill(bill.getId());
		}
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		if (product != null) {
			this.billFreeIssuePK.setProduct(product.getId());
		}
		this.product = product;
	}

	public int getFreePackages() {
		return freePackages;
	}

	public void setFreePackages(int freePackages) {
		this.freePackages = freePackages;
	}

	public int getFreePackets() {
		return freePackets;
	}

	public void setFreePackets(int freePackets) {
		this.freePackets = freePackets;
	}	
}

@Embeddable
class BillFreeIssuePK implements Serializable {

	private static final long serialVersionUID = 8203727783622352233L;

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