package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.ProgramPlan;

public interface ProgramPlanRepository extends JpaRepository<ProgramPlan, Long>{

	List<ProgramPlan> findByFiYearAndPortfolioId(String fiYear,Long portfolioId);

}
