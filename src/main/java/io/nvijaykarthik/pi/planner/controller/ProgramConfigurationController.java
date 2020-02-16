package io.nvijaykarthik.pi.planner.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nvijaykarthik.pi.planner.entity.IterationPlanEntity;
import io.nvijaykarthik.pi.planner.entity.ProgramPlanEntity;
import io.nvijaykarthik.pi.planner.repository.IterationPlanRepository;
import io.nvijaykarthik.pi.planner.repository.ProgramPlanRepository;

@RestController
@RequestMapping("/api")
public class ProgramConfigurationController {

	@Autowired
	IterationPlanRepository iterationPlanRepository;
	@Autowired
	ProgramPlanRepository programPlanRepository;
	
	@PutMapping("/createProgramCalendar")
	@Transactional
	public List<ProgramPlanEntity> createProgramPlanCalendar(@RequestParam String fiYear,@RequestParam Long portfolioId){
		List<ProgramPlanEntity> pies=new ArrayList<ProgramPlanEntity>();
		for(int i=1;i<5;i++) {
			ProgramPlanEntity pie= new ProgramPlanEntity();
			pie.setFiYear(fiYear);
			pie.setPiNo(i);
			pie.setPortfolioId(portfolioId);
			pies.add(pie);
		}
		List<ProgramPlanEntity> sPies=programPlanRepository.saveAll(pies);
		for(ProgramPlanEntity pie:sPies) {
			for(int i=1;i<=5;i++) {
				IterationPlanEntity ite= new IterationPlanEntity();
				ite.setItrNo(i);
				ite.setProgramPlanId(pie.getId());
				ite.setWorkingDays(10);
				iterationPlanRepository.save(ite);
			}
		}
		return pies;		
	}
	
	@PostMapping("/saveProgramCalendar")
	public ProgramPlanEntity saveProgramPlanEntity(@RequestBody ProgramPlanEntity programPlanEntity) {
		return programPlanRepository.save(programPlanEntity);
	}
	
	@PostMapping("/saveIterationCalendar")
	public IterationPlanEntity saveIterationEntity(@RequestBody IterationPlanEntity iterationPlanEntity) {
		return iterationPlanRepository.save(iterationPlanEntity);
	}
	
	@GetMapping("/getProgramCalendar")
	public List<ProgramPlanEntity> getProgramPlanCalendar(@RequestParam String fiYear,@RequestParam Long portfolioId){
		return programPlanRepository.findByFiYearAndPortfolioId(fiYear, portfolioId);
	}
	
	@GetMapping("/getIterationCalendar")
	public List<IterationPlanEntity> getIterationPlanCalendar(@RequestParam Long programPlanId){
		return iterationPlanRepository.findByProgramPlanId(programPlanId);
	}
	
}
