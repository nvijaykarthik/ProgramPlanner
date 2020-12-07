package io.nvijaykarthik.pi.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long>{

}
