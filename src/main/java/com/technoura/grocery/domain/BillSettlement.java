package com.technoura.grocery.domain;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;

import com.technoura.grocery.domain.enums.PaymentType;

@Entity
@Table(name = "bill_settlements")
public class BillSettlement implements Serializable {

	private static final long serialVersionUID = 2171678442539395667L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name = "settled_amount", nullable = true, scale = 2)
	private Float settledAmount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_type")
	private PaymentType paymentType;
	
	@Column(name = "settled_date")
	private Date settledDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_id", foreignKey = @ForeignKey (foreignKeyDefinition = "fk_bill_id", name="bill_settlements_fk_bill_id"))
	private Bill bill;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cheque_id", foreignKey = @ForeignKey (foreignKeyDefinition = "fk_cheque_id", name="bill_settlements_fk_cheque_id"))	
	private Cheque cheque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getSettledAmount() {
		return settledAmount;
	}

	public void setSettledAmount(Float settledAmount) {
		this.settledAmount = settledAmount;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Date getSettledDate() {
		return settledDate;
	}

	public void setSettledDate(Date settledDate) {
		this.settledDate = settledDate;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
}
