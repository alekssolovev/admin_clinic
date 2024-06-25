package com.springlessons.clinicadmin.repository;

import com.springlessons.clinicadmin.entity.Doctor;
import com.springlessons.clinicadmin.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    // Ищем специализации по doctor_id
    List<Specialization> findSpecializationsByDoctorId(Integer id);

    void findDoctorIsActiveTrue(boolean isActive);


    void findDoctorIsActiveFalse(boolean isActive);


}
