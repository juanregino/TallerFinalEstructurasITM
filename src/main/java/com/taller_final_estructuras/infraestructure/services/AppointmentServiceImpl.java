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

@Service
public class AppointmentServiceImpl  implements AppointmentService {

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Autowired
  private AppointmentMapper appointmentMapper;

  @Override
  public AppointmentResponse create(AppointmentRequest rq) {
    Appointment appointment = appointmentMapper.toEntity(rq);
    appointmentRepository.save(appointment);
    return appointmentMapper.toResponse(appointment);

  }

  @Override
  public void delete(Long id) {
    
    this.appointmentRepository.deleteById(id);
  }

  @Override
  public List<AppointmentResponse> findAll() {
    
    return this.appointmentRepository.findAll().stream().map(appointmentMapper::toResponse).toList();
  }

  @Override
  public AppointmentResponse findById(Long id) {
    
    return this.appointmentRepository.findById(id).map(appointmentMapper::toResponse).orElse(null);
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
    return appointmentMapper.toResponse(appointment);
    
  }
  
  
}
