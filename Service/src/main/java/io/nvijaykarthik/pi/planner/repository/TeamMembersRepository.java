package io.nvijaykarthik.pi.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nvijaykarthik.pi.planner.entity.TeamMember;

public interface TeamMembersRepository extends JpaRepository<TeamMember, Long>{

	List<TeamMember> findByTeamId(Long teamId);

}
