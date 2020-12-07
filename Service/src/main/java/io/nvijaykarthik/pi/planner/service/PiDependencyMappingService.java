package io.nvijaykarthik.pi.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nvijaykarthik.pi.planner.entity.PiDependencyMapping;
import io.nvijaykarthik.pi.planner.repository.PiDependencyMappingRepository;

@Service
public class PiDependencyMappingService {
	
	@Autowired
	PiDependencyMappingRepository piDependencyMappingRepository;
	
	public PiDependencyMapping savePiDependencyMapping(PiDependencyMapping entity) {
		return piDependencyMappingRepository.save(entity);
	}
	


}
