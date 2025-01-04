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
@Table(name="PLAN_MASTER")
public class PlanMaster {
	@Id
	@GeneratedValue
	@Column(name="PLAN_ID")
	private Integer planId;
	@Column(name="PLAN_NAME")
	
	private String planeName;
	@Column(name="PLAN_STARTDATE")
	private LocalDate planStartDate;
	@Column(name="PLAN_ENDDATE")
	private LocalDate planEndDate;
	
	@Column(name="ACTIVE_SWITCH")
	private String ActiveSwitch;
	
	@Column(name="PLAN_CATEGORYID")
	private Integer PlanCategoryId;
	
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
