package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.IterationPlan;

public interface IterationPlanRepository extends JpaRepository<IterationPlan, Long>{

	List<IterationPlan> findByProgramPlanId(Long programPlanId);

}
