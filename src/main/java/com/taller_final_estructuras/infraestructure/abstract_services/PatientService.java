package com.taller_final_estructuras.infraestructure.abstract_services;

import com.taller_final_estructuras.api.dto.request.PatientRequest;
import com.taller_final_estructuras.api.dto.response.PatientAppointmentResponse;
import com.taller_final_estructuras.api.dto.response.PatientResponse;

public interface PatientService extends CrudService<PatientRequest, PatientAppointmentResponse, PatientResponse, Long> {
  
}
