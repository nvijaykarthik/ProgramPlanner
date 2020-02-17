package io.nvijaykarthik.pi.planner.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vacation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;
	@Column
	Long portfolioId;
	@Column
	Long teamId;
	@Column
	Long teamMemberId;
	@Column
	Long programPlanId;
	@Column
	Long itrId;
	@Column
	String vacationType;
	@Column
	Integer leaveDays;
	@Column
	String createdBy;
	@Column
	LocalDate createdDate=LocalDate.now();
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public Long getTeamMemberId() {
		return teamMemberId;
	}
	public void setTeamMemberId(Long teamMemberId) {
		this.teamMemberId = teamMemberId;
	}
	public Long getProgramPlanId() {
		return programPlanId;
	}
	public void setProgramPlanId(Long programPlanId) {
		this.programPlanId = programPlanId;
	}
	public Long getItrId() {
		return itrId;
	}
	public void setItrId(Long itrId) {
		this.itrId = itrId;
	}
	public String getVacationType() {
		return vacationType;
	}
	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}
	public Integer getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(Integer leaveDays) {
		this.leaveDays = leaveDays;
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
