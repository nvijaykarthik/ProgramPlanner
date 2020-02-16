package io.nvijaykarthik.pi.planner.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nvijaykarthik.pi.planner.entity.VacationEntity;
import io.nvijaykarthik.pi.planner.service.VacationService;

@RestController
@RequestMapping("/api")
public class VacationController {

	@Autowired
	VacationService vacationService;
	
	
	@PostMapping("/saveVacation")
	public VacationEntity saveVacation(@RequestBody VacationEntity entity) {
		return vacationService.saveVacation(entity);
	}
	
	@GetMapping("/getVacations")
	public Map<Long, Map<Integer, VacationEntity>> getVacationsPerProgram(Long programPlanId, Long teamId,Long portfolioId){
		return vacationService.getVacationPlanForProgram(programPlanId, teamId, portfolioId);
	}
	
	@GetMapping("/getCapacity")
	public Map<Long,Integer> getCapacity(Long programPlanId, Long teamId){
		return vacationService.getCapacity(programPlanId, teamId);
	}
}
