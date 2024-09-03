package com.taller_final_estructuras.infraestructure.abstract_services;

import java.util.List;

import com.taller_final_estructuras.api.dto.request.AppointmentRequest;
import com.taller_final_estructuras.api.dto.response.AppointmentResponse;
import com.taller_final_estructuras.api.dto.response.AppointmentToPatientResponse;
import com.taller_final_estructuras.api.dto.response.PatientResponse;

public interface AppointmentService   {
  public List<PatientResponse> createAppointmentsForAllPatients() ;
}
