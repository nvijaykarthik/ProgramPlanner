package io.nvijaykarthik.pi.planner.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nvijaykarthik.pi.planner.entity.Portfolio;
import io.nvijaykarthik.pi.planner.entity.Team;
import io.nvijaykarthik.pi.planner.entity.TeamMember;
import io.nvijaykarthik.pi.planner.repository.PortfolioRepository;
import io.nvijaykarthik.pi.planner.repository.TeamMembersRepository;
import io.nvijaykarthik.pi.planner.repository.TeamRepository;

@RestController
@RequestMapping("/api")
public class PortAdminController {

	private static final Logger log = LoggerFactory.getLogger(PortAdminController.class);
	
	@Autowired
	PortfolioRepository portfolioRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	TeamMembersRepository teamMembersRepository;
	
	@GetMapping("/portfolio")
	public List<Portfolio> getAllPortfolio(){
		return portfolioRepository.findAll();
	}
	
	@PostMapping("/portfolio")
	public Portfolio savePortfolio(@RequestBody Portfolio portfolio) {
		return portfolioRepository.save(portfolio);
	}
	
	@GetMapping("/teamsForPortfolio")
	public List<Team> getTeamForPortfolio(@RequestParam Long portfolioId){
		return teamRepository.findByPortfolioId(portfolioId);
	}
	
	@PostMapping("/teamsForPortfolio")
	public Team saveTeamForPortfolio(@RequestBody Team team) {
		return teamRepository.save(team);
	}
	
	@GetMapping("/teamMembersForTeam")
	public List<TeamMember> getTeamMembersForTeam(@RequestParam Long teamId){
		return teamMembersRepository.findByTeamId(teamId);
	}
	
	@PostMapping("/teamMembersForTeam")
	public TeamMember saveTeamMembersForTeam(@RequestBody TeamMember teamMember) {
		return teamMembersRepository.save(teamMember);
	}
	
}
