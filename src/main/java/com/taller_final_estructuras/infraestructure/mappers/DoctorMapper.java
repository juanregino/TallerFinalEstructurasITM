package com.taller_final_estructuras.infraestructure.mappers;

import org.springframework.stereotype.Component;

import com.taller_final_estructuras.api.dto.response.DoctorResponse;
import com.taller_final_estructuras.domain.entities.Doctor;

@Component
public class DoctorMapper {
   
  public DoctorResponse toResponse ( Doctor doctor) {
    return DoctorResponse.builder()
        .id(doctor.getId())
        .name(doctor.getName())
        .specialty(doctor.getSpecialty())
        .build();
  }

  public Doctor toEntity ( DoctorResponse response) {
    return Doctor.builder()
        .name(response.getName())
        .specialty(response.getSpecialty())
        .build();
  }

}
