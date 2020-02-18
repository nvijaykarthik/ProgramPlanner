package io.nvijaykarthik.pi.planner.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PiPlanner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;
	@Column
	Long portfolioId;
	@Column
	Long teamId;
	@Column
	Long programPlanId;
	@Column
	Long itrId;
	@Column
	String featureId;
	@Column
	String fJiraLnk;
	@Column
	String storyJiraLnk;
	@Column
	String storyNumber;
	@Column
	String description;
	@Column
	String storyPointsDev;
	@Column
	String storyPointsTst;
	@Column
	String storyPoints;
	@Column
	String comments;
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
	public Long getItrId() {
		return itrId;
	}
	public void setItrId(Long itrId) {
		this.itrId = itrId;
	}
	public String getFeatureId() {
		return featureId;
	}
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}
	public String getStoryNumber() {
		return storyNumber;
	}
	public void setStoryNumber(String storyNumber) {
		this.storyNumber = storyNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStoryPointsDev() {
		return storyPointsDev;
	}
	public void setStoryPointsDev(String storyPointsDev) {
		this.storyPointsDev = storyPointsDev;
	}
	public String getStoryPointsTst() {
		return storyPointsTst;
	}
	public void setStoryPointsTst(String storyPointsTst) {
		this.storyPointsTst = storyPointsTst;
	}
	public String getStoryPoints() {
		return storyPoints;
	}
	public void setStoryPoints(String storyPoints) {
		this.storyPoints = storyPoints;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	public String getfJiraLnk() {
		return fJiraLnk;
	}
	public void setfJiraLnk(String fJiraLnk) {
		this.fJiraLnk = fJiraLnk;
	}
	public String getStoryJiraLnk() {
		return storyJiraLnk;
	}
	public void setStoryJiraLnk(String storyJiraLnk) {
		this.storyJiraLnk = storyJiraLnk;
	}	
}
