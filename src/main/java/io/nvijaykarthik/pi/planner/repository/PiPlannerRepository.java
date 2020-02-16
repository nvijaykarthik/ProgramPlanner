package io.nvijaykarthik.pi.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.PiPlannerEntity;

public interface PiPlannerRepository extends JpaRepository<PiPlannerEntity, Long> {

	
}
