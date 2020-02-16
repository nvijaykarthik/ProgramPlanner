package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.IterationPlanEntity;

public interface IterationPlanRepository extends JpaRepository<IterationPlanEntity, Long>{

	List<IterationPlanEntity> findByProgramPlanId(Long programPlanId);

}
