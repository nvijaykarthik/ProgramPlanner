package io.nvijaykarthik.pi.planner.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IterationPlanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column
	Integer itrNo;
	@Column
	Long programPlanId;
	@Column
	LocalDate startDate;
	@Column
	LocalDate endDate;
	@Column
	Integer workingDays;
	@Column
	String createdBy;
	@Column
	LocalDate createdDate=LocalDate.now();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getItrNo() {
		return itrNo;
	}
	public void setItrNo(Integer itrNo) {
		this.itrNo = itrNo;
	}
	public Long getProgramPlanId() {
		return programPlanId;
	}
	public void setProgramPlanId(Long programPlanId) {
		this.programPlanId = programPlanId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Integer getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(Integer workingDays) {
		this.workingDays = workingDays;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

}
