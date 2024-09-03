package com.taller_final_estructuras.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller_final_estructuras.api.dto.request.PatientRequest;
import com.taller_final_estructuras.api.dto.response.PatientAppointmentResponse;
import com.taller_final_estructuras.api.dto.response.PatientResponse;
import com.taller_final_estructuras.domain.entities.Patient;
import com.taller_final_estructuras.domain.repositories.PatientRepository;
import com.taller_final_estructuras.infraestructure.abstract_services.PatientService;
import com.taller_final_estructuras.infraestructure.mappers.AppointmentMapper;
import com.taller_final_estructuras.infraestructure.mappers.PatientMapper;

@Service
public class PatientServiceImpl implements PatientService {
 
  @Autowired  
    private PatientRepository patientRepository;


  @Autowired
  private PatientMapper patientMapper;

  @Autowired 
  private AppointmentMapper appointmentMapper;
  @Override
  public PatientAppointmentResponse create(PatientRequest rq) {
    Patient patient = patientMapper.toEntity(rq);
    patientRepository.save(patient);
    return patientMapper.toAppointmentResponse(patient);
    
  }

  @Override
  public void delete(Long id) {
    
    this.patientRepository.deleteById(id);
  }

  @Override
  public List<PatientResponse> findAll() {
    
    return this.patientRepository.findAll().stream().map(this::toResponse).toList();
  }

  @Override
  public  PatientResponse findById(Long id) {
    
    return this.patientRepository.findById(id).map(this::toResponse).orElse(null);
  }

  @Override
  public PatientAppointmentResponse update(PatientRequest rq, Long id) {
    Patient patient = this.patientRepository.findById(id).orElse(null);
    if (patient == null) {
      return null;
    }
    patient.setName(rq.getName());
    patient.setAge(rq.getAge());
    patient.setBloodType(rq.getBloodType());
    patientRepository.save(patient);
    return patientMapper.toAppointmentResponse(patient);
    
  }

  

   private PatientResponse toResponse ( Patient patient ) {
    return PatientResponse.builder()
        .id(patient.getId())
        .name(patient.getName())
        .age(patient.getAge())
        .bloodType(patient.getBloodType())
        .appointments(patient.getAppointments().stream().map(appointmentMapper::toAppointmentToPatientResponse).toList())
        .build();
  }
  
}
