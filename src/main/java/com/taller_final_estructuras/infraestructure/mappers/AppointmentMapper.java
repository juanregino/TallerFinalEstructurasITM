package com.taller_final_estructuras.infraestructure.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taller_final_estructuras.api.dto.request.AppointmentRequest;
import com.taller_final_estructuras.api.dto.response.AppointmentResponse;
import com.taller_final_estructuras.api.dto.response.AppointmentToPatientResponse;
import com.taller_final_estructuras.domain.entities.Appointment;
import com.taller_final_estructuras.domain.repositories.DoctorRepository;
import com.taller_final_estructuras.domain.repositories.PatientRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {
  @Autowired
  private final PatientRepository patientRepository;
  @Autowired

  private final DoctorRepository doctorRepository;

  @Autowired

  private final DoctorMapper doctorMapper;

  @Autowired
  private final PatientMapper patientMapper;

  public AppointmentResponse toResponse(Appointment appointment) {
    return AppointmentResponse.builder()
        .id(appointment.getId())
        .description(appointment.getDescription())
        .date(appointment.getDate().toString())
        .patient(patientMapper.toAppointmentResponse(appointment.getPatient()))
        .doctor(doctorMapper.toResponse(appointment.getDoctor()))
        .build();
  }

  public Appointment toEntity(AppointmentRequest request) {

    return Appointment.builder()
        .description(request.getDescription())
        .date(request.getDate())
        .patient(this.patientRepository.findById(request.getPatientId()).orElse(null))
        .doctor(this.doctorRepository.findById(request.getDoctorId()).orElse(null))
        .build();
  }

  public AppointmentToPatientResponse toAppointmentToPatientResponse ( Appointment appointment) {
    return AppointmentToPatientResponse.builder()
        .id(appointment.getId())
        .description(appointment.getDescription())
        .date(appointment.getDate().toString())
        .build();
  }
}
