package io.nvijaykarthik.pi.planner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nvijaykarthik.pi.planner.entity.IterationPlan;
import io.nvijaykarthik.pi.planner.entity.ProgramPlan;
import io.nvijaykarthik.pi.planner.repository.IterationPlanRepository;
import io.nvijaykarthik.pi.planner.repository.ProgramPlanRepository;

@RestController
@RequestMapping("/api")
public class ProgramConfigurationController {

	@Autowired
	IterationPlanRepository iterationPlanRepository;
	@Autowired
	ProgramPlanRepository programPlanRepository;
	
	@PostMapping("/createProgramCalendar")
	@Transactional
	public List<ProgramPlan> createProgramPlanCalendar(@RequestParam String fiYear,@RequestParam Long portfolioId){
		List<ProgramPlan> pies=new ArrayList<ProgramPlan>();
		for(int i=1;i<5;i++) {
			ProgramPlan pie= new ProgramPlan();
			pie.setFiYear(fiYear);
			pie.setPiNo(i);
			pie.setPortfolioId(portfolioId);
			pies.add(pie);
		}
		List<ProgramPlan> sPies=programPlanRepository.saveAll(pies);
		for(ProgramPlan pie:sPies) {
			for(int i=1;i<=5;i++) {
				IterationPlan ite= new IterationPlan();
				ite.setItrNo(i);
				ite.setProgramPlanId(pie.getId());
				ite.setWorkingDays(10);
				iterationPlanRepository.save(ite);
			}
		}
		return pies;		
	}
	
	@PostMapping("/saveProgramCalendar")
	public ProgramPlan saveProgramPlanEntity(@RequestBody ProgramPlan programPlanEntity) {
		return programPlanRepository.save(programPlanEntity);
	}
	
	@PostMapping("/saveIterationCalendar")
	public IterationPlan saveIterationEntity(@RequestBody IterationPlan iterationPlanEntity) {
		
		IterationPlan plan=iterationPlanRepository.findByItrNoAndProgramPlanId(iterationPlanEntity.getItrNo(), iterationPlanEntity.getProgramPlanId());
		if(null!=plan && (null==iterationPlanEntity.getId() || iterationPlanEntity.getId().equals(0)))
			throw new IllegalArgumentException("iteration No is already available");
		return iterationPlanRepository.save(iterationPlanEntity);
	}
	
	@GetMapping("/getProgramCalendar")
	public List<ProgramPlan> getProgramPlanCalendar(@RequestParam String fiYear,@RequestParam Long portfolioId){
		return programPlanRepository.findByFiYearAndPortfolioId(fiYear, portfolioId);
	}
	
	@GetMapping("/getIterationCalendar")
	public List<IterationPlan> getIterationPlanCalendar(@RequestParam Long programPlanId){
		return iterationPlanRepository.findByProgramPlanId(programPlanId);
	}
	
	@GetMapping("/getConfiguredYears")
	public Set<String> getConfiguredYears(){
		List<ProgramPlan> pp=programPlanRepository.findAll();
		return pp.stream().map(p->p.getFiYear()).distinct().collect(Collectors.toSet());
	}
	
}
