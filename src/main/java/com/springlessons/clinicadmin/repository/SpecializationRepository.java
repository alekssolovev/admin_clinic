package com.springlessons.clinicadmin.repository;

import com.springlessons.clinicadmin.entity.Specialization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecializationRepository
        extends CrudRepository<Specialization, Integer> {
    //Ищем все специализации с is_active = false.
    @Query(nativeQuery = true, value = "SELECT sh.specialization_id FROM specialization sh " +
            "WHERE  IS  sh.is_active = false")
    List<Integer> findSpecializationsIsActiveFalse();
}
