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

import com.technoura.grocery.domain.enums.ChequeStatus;

@Entity
@Table(name = "cheques")
public class Cheque implements Serializable {

	private static final long serialVersionUID = -6319624599779281120L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name = "cheque_no")
	private String chequeNo;
	
	@Column(name = "bank_name")
	private String bankName;
	
	private String note;
	
	@Column(name = "cheque_date")
	private Date chequeDate;
	
	@Column(name = "receive_date")
	private Date receiveDate;
	
	@OneToMany(mappedBy = "cheque")
	private List<BillSettlement> billSettlements;
	
	@Enumerated(EnumType.STRING)
	private ChequeStatus status;
	
	@Embedded
	private EntityLog entityLog;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
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

	public ChequeStatus getStatus() {
		return status;
	}

	public void setStatus(ChequeStatus status) {
		this.status = status;
	}

	public EntityLog getEntityLog() {
		return entityLog;
	}

	public void setEntityLog(EntityLog entityLog) {
		this.entityLog = entityLog;
	}
}
