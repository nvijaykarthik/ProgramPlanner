package io.nvijaykarthik.pi.planner.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProgramGoal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;
	@Column
	Long portfolioId;
	@Column
	Long teamId;
	@Column(unique = true,nullable = false)
	Long programPlanId;
	@Column
	String piObjective;
	@Column
	String commited;
	@Column
	String unCommited;
	@Column
	String risk;
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
	public Long getProgramPlanId() {
		return programPlanId;
	}
	public void setProgramPlanId(Long programPlanId) {
		this.programPlanId = programPlanId;
	}
	public String getPiObjective() {
		return piObjective;
	}
	public void setPiObjective(String piObjective) {
		this.piObjective = piObjective;
	}
	public String getCommited() {
		return commited;
	}
	public void setCommited(String commited) {
		this.commited = commited;
	}
	public String getUnCommited() {
		return unCommited;
	}
	public void setUnCommited(String unCommited) {
		this.unCommited = unCommited;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
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
