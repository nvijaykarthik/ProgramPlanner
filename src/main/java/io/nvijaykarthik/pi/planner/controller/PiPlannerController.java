package io.nvijaykarthik.pi.planner.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nvijaykarthik.pi.planner.entity.PiPlanner;
import io.nvijaykarthik.pi.planner.entity.ProgramGoal;
import io.nvijaykarthik.pi.planner.repository.PiPlannerRepository;
import io.nvijaykarthik.pi.planner.repository.ProgramGoalRepository;

@RestController
@RequestMapping("/api")
public class PiPlannerController {

	@Autowired
	PiPlannerRepository piPlannerRepository;
	
	@Autowired
	ProgramGoalRepository programGoalRepository;
	
	@PostMapping("/savePiPlanner")
	public PiPlanner savePiPlanner(@RequestBody PiPlanner piPlanner) {
		return piPlannerRepository.save(piPlanner);
	}
	
	@GetMapping("/getPiPlanners")
	public List<PiPlanner> getPiPlanners(@RequestParam Long programId,@RequestParam Long teamId){
		return piPlannerRepository.findByProgramPlanIdAndTeamId(programId, teamId);
	}
	
	@PostMapping("/saveProgramGoal")
	public ProgramGoal saveProgramGoal(@RequestBody ProgramGoal programGoal) {
		return programGoalRepository.save(programGoal);
	}
	
	@GetMapping("/getProgramGoalForTeam")
	public ProgramGoal getProgramGoal(@RequestParam Long programId,@RequestParam Long teamId){
		return programGoalRepository.findByProgramPlanIdAndTeamId(programId, teamId);
	}
	
	@GetMapping("/getProgramGoalsForPortfolio")
	public List<ProgramGoal> getProgramGoals(@RequestParam Long portfolioId){
		return programGoalRepository.findByPortfolioId(portfolioId);
	}
	
	public Map<Long,List<PiPlanner>> getIterationDetails(@RequestParam Long programId,@RequestParam Long teamId){
		List<PiPlanner> piPlanners=piPlannerRepository.findByProgramPlanIdAndTeamId(programId, teamId);
		return piPlanners.stream().collect( 
                Collectors.groupingBy(PiPlanner::getItrId));
	}

}
