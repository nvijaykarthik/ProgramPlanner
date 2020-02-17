package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.ProgramGoal;

public interface ProgramGoalRepository extends JpaRepository<ProgramGoal, Long> {
	List<ProgramGoal> findByPortfolioId(Long portfolioId);
	ProgramGoal findByProgramPlanIdAndTeamId(Long programPlanId,Long teamId);
}
