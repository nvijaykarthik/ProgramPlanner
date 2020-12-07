package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.PiPlanner;

public interface PiPlannerRepository extends JpaRepository<PiPlanner, Long> {

	List<PiPlanner> findByProgramPlanIdAndTeamId(Long programPlanId,Long teamId);
}
