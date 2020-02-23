package io.nvijaykarthik.pi.planner.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nvijaykarthik.pi.planner.domain.CapacityDomain;
import io.nvijaykarthik.pi.planner.entity.Vacation;
import io.nvijaykarthik.pi.planner.service.VacationService;

@RestController
@RequestMapping("/api")
public class VacationController {

	@Autowired
	VacationService vacationService;
	
	
	@PostMapping("/saveVacation")
	public Vacation saveVacation(@RequestBody Vacation entity) {
		return vacationService.saveVacation(entity);
	}
	
	@GetMapping("/getVacations")
	public Map<Long, Map<Integer, Vacation>> getVacationsPerProgram(@RequestParam Long programPlanId, @RequestParam Long teamId,@RequestParam Long portfolioId){
		return vacationService.getVacationPlanForProgram(programPlanId, teamId, portfolioId);
	}
	
	@GetMapping("/getCapacity")
	public  List<CapacityDomain> getCapacity(@RequestParam Long programPlanId, @RequestParam Long teamId){
		return vacationService.getCapacity(programPlanId, teamId);
	}
}
