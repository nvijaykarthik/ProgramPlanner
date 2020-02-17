package io.nvijaykarthik.pi.planner.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PiDependencyMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;
	@Column
	Long portfolioId;
	
	@Column(unique = true,nullable = false)
	Long programPlanId;
	@Column
	Long myTeamId;
	@Column
	String myFeature;
	@Column
	Long dependTeamId;
	@Column
	Long dependFeature;
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
	public Long getProgramPlanId() {
		return programPlanId;
	}
	public void setProgramPlanId(Long programPlanId) {
		this.programPlanId = programPlanId;
	}
	public Long getMyTeamId() {
		return myTeamId;
	}
	public void setMyTeamId(Long myTeamId) {
		this.myTeamId = myTeamId;
	}
	public String getMyFeature() {
		return myFeature;
	}
	public void setMyFeature(String myFeature) {
		this.myFeature = myFeature;
	}
	public Long getDependTeamId() {
		return dependTeamId;
	}
	public void setDependTeamId(Long dependTeamId) {
		this.dependTeamId = dependTeamId;
	}
	public Long getDependFeature() {
		return dependFeature;
	}
	public void setDependFeature(Long dependFeature) {
		this.dependFeature = dependFeature;
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
