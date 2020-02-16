package io.nvijaykarthik.pi.planner.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PiPlannerEntity {

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
	String storyNUmber;
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
}
