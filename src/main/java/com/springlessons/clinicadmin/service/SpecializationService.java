package com.springlessons.clinicadmin.service;

import com.springlessons.clinicadmin.entity.Specialization;
import com.springlessons.clinicadmin.repository.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {
    private final SpecializationRepository specializationRepository;

    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public int addSpecialization(Specialization specialization){
        return specializationRepository.save(specialization).getId();
    }

    //есть ли в листе доктора неактивная специализация
    public boolean InactiveSpecialization(List<Specialization> specializations){
        return specializationRepository.findSpecializationsIsActiveFalse().size() != 0;

    }
}
