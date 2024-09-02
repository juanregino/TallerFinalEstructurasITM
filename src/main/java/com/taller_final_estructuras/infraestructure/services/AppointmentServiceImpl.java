package com.taller_final_estructuras.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller_final_estructuras.api.dto.request.AppointmentRequest;
import com.taller_final_estructuras.api.dto.response.AppointmentResponse;
import com.taller_final_estructuras.api.dto.response.AppointmentToPatientResponse;
import com.taller_final_estructuras.domain.entities.Appointment;
import com.taller_final_estructuras.domain.repositories.AppointmentRepository;
import com.taller_final_estructuras.infraestructure.abstract_services.AppointmentService;
import com.taller_final_estructuras.infraestructure.mappers.AppointmentMapper;
import com.taller_final_estructuras.infraestructure.mappers.DoctorMapper;
import com.taller_final_estructuras.infraestructure.mappers.PatientMapper;

@Service
public class AppointmentServiceImpl  implements AppointmentService {

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Autowired
  private AppointmentMapper appointmentMapper;
  
  @Autowired
  private PatientMapper patientMapper;
  @Autowired
  private DoctorMapper doctorMapper;
  
  @Override
  public AppointmentResponse create(AppointmentRequest rq ) {
    Appointment appointment = appointmentMapper.toEntity(rq);
    appointmentRepository.save(appointment);
    return this.toResponse(appointment );

  }

  @Override
  public void delete(Long id) {
    
    this.appointmentRepository.deleteById(id);
  }

  @Override
  public List<AppointmentResponse> findAll() {
    
    return this.appointmentRepository.findAll().stream().map(this::toResponse).toList();
  }

  @Override
  public AppointmentResponse findById(Long id) {
    
    return this.appointmentRepository.findById(id).map(this::toResponse).orElse(null);
  }

  

  @Override
  public AppointmentResponse update(AppointmentRequest rq, Long id) {
    Appointment appointment = this.appointmentRepository.findById(id).orElse(null);
    if (appointment == null) {
      return null;
    }
    appointment.setDescription(rq.getDescription());
    appointment.setDate(rq.getDate());
    appointmentRepository.save(appointment);
    return this.toResponse(appointment );
    
  }
  
  public AppointmentResponse toResponse(Appointment appointment) {
    return AppointmentResponse.builder()
        .id(appointment.getId())
        .description(appointment.getDescription())
        .date(appointment.getDate().toString())
        .patient(patientMapper.toAppointmentResponse(appointment.getPatient()))
        .doctor(doctorMapper.toResponse(appointment.getDoctor()))
        .build();
  }
  
}
