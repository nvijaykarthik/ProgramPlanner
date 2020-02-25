package io.nvijaykarthik.pi.planner.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nvijaykarthik.pi.planner.domain.CapacityDomain;
import io.nvijaykarthik.pi.planner.entity.IterationPlan;
import io.nvijaykarthik.pi.planner.entity.TeamMember;
import io.nvijaykarthik.pi.planner.entity.Vacation;
import io.nvijaykarthik.pi.planner.repository.IterationPlanRepository;
import io.nvijaykarthik.pi.planner.repository.TeamMembersRepository;
import io.nvijaykarthik.pi.planner.repository.VacationRepository;

@Service
public class VacationService {

	@Autowired
	private VacationRepository vacationRepository;

	@Autowired
	private TeamMembersRepository teamMembersRepository;

	@Autowired
	private IterationPlanRepository iterationPlanRepository;

	public Vacation saveVacation(Vacation entity) {
		return vacationRepository.save(entity);
	}

	public Map<String, Map<Integer, Vacation>> getVacationPlanForProgram(Long programPlanId, Long teamId,Long portfolioId) {
		List<Vacation> vacs = vacationRepository.findByTeamIdAndProgramPlanId(teamId, programPlanId);
		List<TeamMember> teamMembers = teamMembersRepository.findByTeamId(teamId);
		List<TeamMember> dev_tstMembers=teamMembers.stream().filter(tm->(tm.getRole().equals("DEV") || tm.getRole().equals("TEST"))).collect(Collectors.toList());
		List<IterationPlan> iterationPlanEntities = iterationPlanRepository.findByProgramPlanId(programPlanId);
		Map<String, Map<Integer, Vacation>> vacations = new HashMap<>();
		// fill map with default value
		for (TeamMember tm : dev_tstMembers) {
			Map<Integer, Vacation> itrData = new HashMap<>();
			for (IterationPlan itr : iterationPlanEntities) {
				Vacation vac = vacs.stream()
						.filter(v -> v.getItrId().equals(itr.getId()) && v.getTeamMemberId().equals(tm.getId()))
						.findAny().orElse(null);
				if (null == vac) {
					vac = new Vacation();
					vac.setItrId(itr.getId());
					vac.setLeaveDays(0);
					vac.setPortfolioId(portfolioId);
					vac.setProgramPlanId(programPlanId);
					vac.setTeamId(teamId);
					vac.setTeamMemberId(tm.getId());
					vac.setTeamMemberName(tm.getMemberName());
					vac.setItrNo(itr.getItrNo());
				}
				
				itrData.put(itr.getItrNo(), vac);
			}
			vacations.put(tm.getMemberName(), itrData);
		}
		return vacations;
	}
	
	public List<CapacityDomain> getCapacity(Long programPlanId, Long teamId){
		List<Vacation> vacs = vacationRepository.findByTeamIdAndProgramPlanId(teamId, programPlanId);
		List<IterationPlan> iterationPlanEntities = iterationPlanRepository.findByProgramPlanId(programPlanId);
		List<TeamMember> teamMembers = teamMembersRepository.findByTeamId(teamId);
		List<TeamMember> dev_tstMembers=teamMembers.stream().filter(tm->(tm.getRole().equals("DEV") || tm.getRole().equals("TEST"))).collect(Collectors.toList());
		Integer totalMembers=dev_tstMembers.size();
		 List<CapacityDomain> capacities= new ArrayList<CapacityDomain>();
		for(IterationPlan itrp:iterationPlanEntities) {
			Integer vacSum=vacs.stream().filter(v->v.getItrId().equals(itrp.getId())).mapToInt(o->o.getLeaveDays()).sum();
			Integer cap=(totalMembers*itrp.getWorkingDays())-vacSum;
			CapacityDomain capacity = new CapacityDomain();
			capacity.setCapacity(cap);
			capacity.setItrId(itrp.getId());
			capacity.setItrNo(itrp.getItrNo());
			capacities.add(capacity);
		}
		return capacities;
	}
}
