package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

	List<Team> findByPortfolioId(Long portfolioId);

}
