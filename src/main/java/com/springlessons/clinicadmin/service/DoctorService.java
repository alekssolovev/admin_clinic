package com.springlessons.clinicadmin.service;

import com.springlessons.clinicadmin.entity.Doctor;
import com.springlessons.clinicadmin.entity.Specialization;
import com.springlessons.clinicadmin.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    SpecializationService specializationService;
    String activeDoctors;
    String inactiveDoctors;
    Integer countOfactiveDoctors = 0;
    Integer countOfinactiveDoctors = 0;

    public String getActiveDoctors(DoctorRepository doctorRepository, Doctor doctor) {
        //LiString> listOfActiveDoctors= new ArrayList<>();
        activeDoctors = "Количество активных докторов: ";
        //doctorRepository.findSpecializationsByDoctorId(doctor.getId());
        if(specializationService.InactiveSpecialization (doctor.getSpecializations()))
            doctorRepository.findDoctorIsActiveTrue(doctor.isActive());
            countOfactiveDoctors+=1;
            String listOfActiveDoctors=  new String(activeDoctors+countOfactiveDoctors);

        return listOfActiveDoctors;
    }

    public String getInactiveDoctors(DoctorRepository doctorRepository, Doctor doctor) {
        inactiveDoctors = "Количество неактивных докторов: ";
        if(specializationService.InactiveSpecialization (doctor.getSpecializations()))
            doctorRepository.findDoctorIsActiveFalse(doctor.isActive());
            countOfinactiveDoctors+=1;
            String listOfInactiveDoctors = new String(inactiveDoctors+countOfinactiveDoctors);
        return  listOfInactiveDoctors;
    }



}
