package com.ashok.it.Entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {
	
	@Id
	@GeneratedValue
	@Column(name ="CATEGORY_ID")
	private Integer categoryId;
	@Column(name ="CATEGORY_NAME")
	private String categoryName;
	@Column(name ="ACTIVE_SWITCH")
	private String ActiveSwitch;
	@Column(name ="CREATED_BY")
	private String createdBy;
	@Column(name="UPDATED_BY")
	private String updatedBy;
	@Column(name ="CREATE_DATE",updatable = false)
	@CreationTimestamp()
	private LocalDate createDate;
	@Column(name ="UPDATE_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;

}
