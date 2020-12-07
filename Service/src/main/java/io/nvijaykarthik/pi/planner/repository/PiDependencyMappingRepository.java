package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.PiDependencyMapping;

public interface PiDependencyMappingRepository extends JpaRepository<PiDependencyMapping, Long> {
	List<PiDependencyMapping> findByProgramPlanId(Long programPlanId);
	
	List<PiDependencyMapping> findByYearAndPortfolioIdAndProgramPlanId(Long year,Long portolioId, Long programPlanId);
}
