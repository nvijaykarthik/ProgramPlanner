package io.nvijaykarthik.pi.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nvijaykarthik.pi.planner.entity.IterationPlan;
import io.nvijaykarthik.pi.planner.entity.PiDependencyMapping;
import io.nvijaykarthik.pi.planner.entity.PiPlanner;
import io.nvijaykarthik.pi.planner.repository.PiDependencyMappingRepository;
import io.nvijaykarthik.pi.planner.service.PiDependencyMappingService;

@RestController
@RequestMapping("/api")
public class PiDependencyMappingController {
	
	@Autowired
	PiDependencyMappingService piDependencyMappingService;


	@Autowired
	PiDependencyMappingRepository piDependencyMappingRepository;

	@PostMapping("/savePiDependencyMapping")
	public PiDependencyMapping savePiPlanner(@RequestBody PiDependencyMapping piDependencyMapping) {
		return piDependencyMappingService.savePiDependencyMapping(piDependencyMapping);
	}
	
	@GetMapping("/getDependencyMappings")
	public List<PiDependencyMapping> getDependencyMappings(@RequestParam Long year,@RequestParam Long portolioId, @RequestParam Long programPlanId){
		List<PiDependencyMapping> piDependencyMappings = piDependencyMappingRepository.findByYearAndPortfolioIdAndProgramPlanId(year, portolioId, programPlanId);
		
		return piDependencyMappings;
	}
	
	@GetMapping("/removeDependencyMapping")
	public boolean getDependencyMappings(@RequestParam Long id){
		boolean status=false;
		try {
			piDependencyMappingRepository.deleteById(id);
			status=true;
		} catch (Exception e) {
			System.out.println("Error while removing dependency::"+id);
		}
		 
		
		return status;
	}

}
