package io.nvijaykarthik.pi.planner.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nvijaykarthik.pi.planner.entity.IterationPlanEntity;
import io.nvijaykarthik.pi.planner.entity.TeamMember;
import io.nvijaykarthik.pi.planner.entity.VacationEntity;
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

	public VacationEntity saveVacation(VacationEntity entity) {
		return vacationRepository.save(entity);
	}

	public Map<Long, Map<Integer, VacationEntity>> getVacationPlanForProgram(Long programPlanId, Long teamId,Long portfolioId) {
		List<VacationEntity> vacs = vacationRepository.findByTeamIdAndProgramPlanId(teamId, programPlanId);
		List<TeamMember> teamMembers = teamMembersRepository.findByTeamId(teamId);
		List<IterationPlanEntity> iterationPlanEntities = iterationPlanRepository.findByProgramPlanId(programPlanId);
		Map<Long, Map<Integer, VacationEntity>> vacations = new HashMap<>();
		// fill map with default value
		for (TeamMember tm : teamMembers) {
			Map<Integer, VacationEntity> itrData = new HashMap<>();
			for (IterationPlanEntity itr : iterationPlanEntities) {
				VacationEntity vac = vacs.stream()
						.filter(v -> v.getItrId().equals(itr.getId()) && v.getTeamMemberId().equals(tm.getId()))
						.findAny().orElse(null);
				if (null == vac) {
					vac = new VacationEntity();
					vac.setItrId(itr.getId());
					vac.setLeaveDays(0);
					vac.setPortfolioId(portfolioId);
					vac.setProgramPlanId(programPlanId);
					vac.setTeamId(teamId);
					vac.setTeamMemberId(tm.getId());
				}
				
				itrData.put(itr.getItrNo(), vac);
			}
			vacations.put(tm.getId(), itrData);
		}
		return vacations;
	}
	
	public Map<Long,Integer> getCapacity(Long programPlanId, Long teamId){
		List<VacationEntity> vacs = vacationRepository.findByTeamIdAndProgramPlanId(teamId, programPlanId);
		List<IterationPlanEntity> iterationPlanEntities = iterationPlanRepository.findByProgramPlanId(programPlanId);
		List<TeamMember> teamMembers = teamMembersRepository.findByTeamId(teamId);
		Integer totalMembers=teamMembers.size();
		Map<Long,Integer> capacity=new HashMap<>();
		for(IterationPlanEntity itrp:iterationPlanEntities) {
			Integer vacSum=vacs.stream().filter(v->v.getItrId().equals(itrp.getId())).mapToInt(o->o.getLeaveDays()).sum();
			Integer cap=(totalMembers*itrp.getWorkingDays())-vacSum;
			capacity.put(itrp.getId(),cap);
		}
		return capacity;
	}
}
