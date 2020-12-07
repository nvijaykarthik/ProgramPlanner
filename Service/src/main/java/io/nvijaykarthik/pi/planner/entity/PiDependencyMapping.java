package io.nvijaykarthik.pi.planner.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PiDependencyMapping implements Serializable
{
	

	private static final long serialVersionUID = -6356731158485775744L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column
	Long year;
	
	@Column
	Long portfolioId;
	
	@Column
	Long programPlanId;
	
	@Column
	String myTeam;
	
	@Column
	Long myTeamId;
	
	@Column
	String myFeature;
	
	@Column
	Long myTeamItrId;
	
	@Column
	String dependentTeam;
	
	@Column
	Long dependentTeamId;
	
	@Column
	String dependentFeature;
	
	@Column
	Long dependentTeamItrId;
	
	@Column
	String createdBy="DEV";
	
	@Column
	Date createdDate= new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
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

	public String getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
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

	public Long getMyTeamItrId() {
		return myTeamItrId;
	}

	public void setMyTeamItrId(Long myTeamItrId) {
		this.myTeamItrId = myTeamItrId;
	}

	public String getDependentTeam() {
		return dependentTeam;
	}

	public void setDependentTeam(String dependentTeam) {
		this.dependentTeam = dependentTeam;
	}

	public Long getDependentTeamId() {
		return dependentTeamId;
	}

	public void setDependentTeamId(Long dependentTeamId) {
		this.dependentTeamId = dependentTeamId;
	}

	public String getDependentFeature() {
		return dependentFeature;
	}

	public void setDependentFeature(String dependentFeature) {
		this.dependentFeature = dependentFeature;
	}

	public Long getDependentTeamItrId() {
		return dependentTeamItrId;
	}

	public void setDependentTeamItrId(Long dependentTeamItrId) {
		this.dependentTeamItrId = dependentTeamItrId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "PiDependencyMapping [id=" + id + ", year=" + year + ", portfolioId=" + portfolioId + ", programPlanId="
				+ programPlanId + ", myTeam=" + myTeam + ", myTeamId=" + myTeamId + ", myFeature=" + myFeature
				+ ", myTeamItrId=" + myTeamItrId + ", dependentTeam=" + dependentTeam + ", dependentTeamId="
				+ dependentTeamId + ", dependentFeature=" + dependentFeature + ", dependentTeamItrId="
				+ dependentTeamItrId + ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
	}
	
	
	
	
}
