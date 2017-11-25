package com.technoura.grocery.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.technoura.grocery.domain.enums.PromotionalType;
import com.technoura.grocery.domain.enums.Status;

@Entity
@Table(name = "promotions")
public class Promotion implements Serializable {

	private static final long serialVersionUID = -7483201233526826282L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Column(length = 1500)
	private String description;
	
	@OneToOne
	@JoinColumn(name = "image_id", unique=true, nullable=false, updatable=false)
	private Image image;
	
	// ACTIVE, INACTIVE
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	private PromotionalType type;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")	
	private Date endDate;
	
	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	private List<PromotionalProduct> promotionalProducts;
	
	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	private List<OrderPromotion> orderPromotions;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public PromotionalType getType() {
		return type;
	}

	public void setType(PromotionalType type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
