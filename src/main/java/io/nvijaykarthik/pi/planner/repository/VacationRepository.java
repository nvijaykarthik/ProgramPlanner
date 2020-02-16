package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.VacationEntity;

public interface VacationRepository extends JpaRepository<VacationEntity, Long> {

	List<VacationEntity> findByPortfolioIdAndTeamIdAndProgramPlanId(Long PortfolioId,Long teamId,Long  programPlanId);
	List<VacationEntity> findByTeamIdAndProgramPlanId(Long teamId,Long  programPlanId);

}
