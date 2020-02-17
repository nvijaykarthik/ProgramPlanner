package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.Vacation;

public interface VacationRepository extends JpaRepository<Vacation, Long> {

	List<Vacation> findByPortfolioIdAndTeamIdAndProgramPlanId(Long PortfolioId,Long teamId,Long  programPlanId);
	List<Vacation> findByTeamIdAndProgramPlanId(Long teamId,Long  programPlanId);

}
