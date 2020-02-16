package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.ProgramPlanEntity;

public interface ProgramPlanRepository extends JpaRepository<ProgramPlanEntity, Long>{

	List<ProgramPlanEntity> findByFiYearAndPortfolioId(String fiYear,Long portfolioId);

}
