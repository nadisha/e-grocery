package com.technoura.grocery.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.technoura.grocery.domain.enums.Status;

@Entity
@Table(name = "bills")
public class Bill implements Serializable {

	private static final long serialVersionUID = 261306250018405534L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name = "bill_number")
	private String billNumber;
	
	@Column(name = "bill_date")
	private Date billDate;
	
	@Column(name = "bill_amount", nullable = true, scale = 2)
	private Float billAmount;
			
	@Column(name = "remaining_amount", nullable = true, scale = 2)
	private Float remainingAmount;
	
	// PAY_IN_PROGRESS and COMPLETE
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Embedded
	private EntityLog entityLog;
	
	@Column(name = "bill_profit", nullable = true, scale = 2)
	private Float billProfit;
	
	@Column(nullable = true, scale = 2)
	private Float discount;
	
	@OneToMany(mappedBy = "bill")
	private List<BillProduct> billProducts;
	
	@OneToMany(mappedBy = "bill")
	private List<BillFreeIssue> billFreeIssues;
	
	@OneToMany(mappedBy = "bill")
	private List<BillSettlement> billSettlements;
	
	@OneToMany(mappedBy = "bill")
	private List<BillMarketReturn> billMarketReturns;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Float billAmount) {
		this.billAmount = billAmount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public EntityLog getEntityLog() {
		return entityLog;
	}

	public void setEntityLog(EntityLog entityLog) {
		this.entityLog = entityLog;
	}

	public Float getBillProfit() {
		return billProfit;
	}

	public void setBillProfit(Float billProfit) {
		this.billProfit = billProfit;
	}

	public Float getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(Float remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public List<BillProduct> getBillProducts() {
		if (this.billProducts == null) {
			billProducts = new ArrayList<BillProduct>();
		}
		return billProducts;
	}

	public void setBillProducts(List<BillProduct> billProducts) {
		this.billProducts = billProducts;
	}

	public List<BillSettlement> getBillSettlements() {
		if (billSettlements == null) {
			billSettlements = new ArrayList<BillSettlement>();
		}
		return billSettlements;
	}

	public void setBillSettlements(List<BillSettlement> billSettlements) {
		this.billSettlements = billSettlements;
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
}
