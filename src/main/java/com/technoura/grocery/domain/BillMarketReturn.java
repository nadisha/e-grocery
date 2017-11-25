package com.technoura.grocery.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.technoura.grocery.domain.enums.MRSettlementType;

@Entity
@Table(name = "bill_market_return")
public class BillMarketReturn implements Serializable {

	private static final long serialVersionUID = 705366441431463326L;

	@Id
	private BillMarketReturnPK billMarketReturnPK = new BillMarketReturnPK();
	
	@ManyToOne
	@JoinColumn(name = "bill_id",  nullable = false, updatable = false, insertable = false)	
	private Bill bill;
	
	@ManyToOne
	@JoinColumn(name = "product_id",  nullable = false, updatable = false, insertable = false)	
	private Product product;
	
	@Column(name = "mr_packages")
	private int mrPackages;
	
	@Column(name = "mr_packets")
	private int mrPackets;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "customer_settlement")
	private MRSettlementType customerSettlement;
	
	@Column(name = "customer_settled_amount", nullable = true, scale = 2)
	private Float customerSettledAmount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "suppler_settlement")
	private MRSettlementType supplerSettlement;
	
	private Date supplerSettledDate;

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		if (bill != null) {
			this.billMarketReturnPK.setBill(bill.getId());
		}
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		if (product != null) {
			this.billMarketReturnPK.setProduct(product.getId());
		}
		this.product = product;
	}

	public int getMrPackages() {
		return mrPackages;
	}

	public void setMrPackages(int mrPackages) {
		this.mrPackages = mrPackages;
	}

	public int getMrPackets() {
		return mrPackets;
	}

	public void setMrPackets(int mrPackets) {
		this.mrPackets = mrPackets;
	}

	public MRSettlementType getCustomerSettlement() {
		return customerSettlement;
	}

	public void setCustomerSettlement(MRSettlementType customerSettlement) {
		this.customerSettlement = customerSettlement;
	}

	public Float getCustomerSettledAmount() {
		return customerSettledAmount;
	}

	public void setCustomerSettledAmount(Float customerSettledAmount) {
		this.customerSettledAmount = customerSettledAmount;
	}

	public MRSettlementType getSupplerSettlement() {
		return supplerSettlement;
	}

	public void setSupplerSettlement(MRSettlementType supplerSettlement) {
		this.supplerSettlement = supplerSettlement;
	}

	public Date getSupplerSettledDate() {
		return supplerSettledDate;
	}

	public void setSupplerSettledDate(Date supplerSettledDate) {
		this.supplerSettledDate = supplerSettledDate;
	}
}

@Embeddable
class BillMarketReturnPK implements Serializable {

	private static final long serialVersionUID = 830662281941711130L;

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