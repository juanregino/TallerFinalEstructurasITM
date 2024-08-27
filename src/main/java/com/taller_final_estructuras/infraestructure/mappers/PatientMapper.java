package com.taller_final_estructuras.infraestructure.mappers;

import org.springframework.stereotype.Component;

import com.taller_final_estructuras.api.dto.request.PatientRequest;
import com.taller_final_estructuras.api.dto.response.PatientAppointmentResponse;
import com.taller_final_estructuras.api.dto.response.PatientResponse;
import com.taller_final_estructuras.domain.entities.Patient;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PatientMapper {
 

  private final AppointmentMapper appointmentMapper;
  
  public PatientResponse toResponse ( Patient patient) {
    return PatientResponse.builder()
        .id(patient.getId())
        .name(patient.getName())
        .age(patient.getAge())
        .bloodType(patient.getBloodType())
        .appointments(patient.getAppointments().stream().map(appointmentMapper::toAppointmentToPatientResponse).toList())
        .build();
  }

  public Patient toEntity ( PatientRequest request) { 
    return Patient.builder()
        .name(request.getName())
        .age(request.getAge())
        .bloodType(request.getBloodType())
        .build();
  }


  public PatientAppointmentResponse toAppointmentResponse ( Patient patient) {
    return PatientAppointmentResponse.builder()
        .id(patient.getId())
        .name(patient.getName())
        .age(patient.getAge())
        .bloodType(patient.getBloodType())        
        .build();
  }
}
