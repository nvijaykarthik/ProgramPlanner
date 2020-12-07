package io.nvijaykarthik.pi.planner.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProgramPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column
	Integer piNo;
	@Column
	String fiYear;
	@Column
	Long portfolioId;
	@Column
	LocalDate startDate;
	@Column
	LocalDate endDate;
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
	public Integer getPiNo() {
		return piNo;
	}
	public void setPiNo(Integer piNo) {
		this.piNo = piNo;
	}

	public Long getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
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
	public String getFiYear() {
		return fiYear;
	}
	public void setFiYear(String fiYear) {
		this.fiYear = fiYear;
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
