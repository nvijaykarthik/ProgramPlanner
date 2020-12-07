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

import io.nvijaykarthik.pi.planner.entity.IterationPlan;
import io.nvijaykarthik.pi.planner.entity.PiPlanner;
import io.nvijaykarthik.pi.planner.entity.ProgramGoal;
import io.nvijaykarthik.pi.planner.repository.IterationPlanRepository;
import io.nvijaykarthik.pi.planner.repository.PiPlannerRepository;
import io.nvijaykarthik.pi.planner.repository.ProgramGoalRepository;

@RestController
@RequestMapping("/api")
public class PiPlannerController {

	@Autowired
	PiPlannerRepository piPlannerRepository;
	
	@Autowired
	ProgramGoalRepository programGoalRepository;
	
	@Autowired
	private IterationPlanRepository iterationPlanRepository;
	
	@PostMapping("/savePiPlanner")
	public PiPlanner savePiPlanner(@RequestBody PiPlanner piPlanner) {
		return piPlannerRepository.save(piPlanner);
	}
	
	@GetMapping("/getPiPlanners")
	public List<PiPlanner> getPiPlanners(@RequestParam Long programId,@RequestParam Long teamId){
		List<IterationPlan> iterationPlanEntities = iterationPlanRepository.findByProgramPlanId(programId);
		List<PiPlanner> planList=piPlannerRepository.findByProgramPlanIdAndTeamId(programId, teamId);
		for(PiPlanner pi:planList) {
			IterationPlan itr=iterationPlanEntities.stream().filter(itrs->{
				return itrs.getId().equals(pi.getItrId());
			}).findFirst().orElse(null);
			
			if(null!=itr) {
				pi.setItrNo(itr.getItrNo());
			}
		}
		return planList;
	}
	
	@PostMapping("/saveProgramGoal")
	public ProgramGoal saveProgramGoal(@RequestBody ProgramGoal programGoal) {
		return programGoalRepository.save(programGoal);
	}
	
	@GetMapping("/getProgramGoalForTeam")
	public ProgramGoal getProgramGoal(@RequestParam Long programId,@RequestParam Long teamId){
		ProgramGoal pg=programGoalRepository.findByProgramPlanIdAndTeamId(programId, teamId);
		if(null==pg) {
			pg=new ProgramGoal();
			pg.setProgramPlanId(programId);
			pg.setTeamId(teamId);
			pg.setPiObjective("");
		}
		return pg;
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
