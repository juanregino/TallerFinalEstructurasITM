package com.taller_final_estructuras.infraestructure.abstract_services;

import com.taller_final_estructuras.api.dto.request.AppointmentRequest;
import com.taller_final_estructuras.api.dto.response.AppointmentResponse;
import com.taller_final_estructuras.api.dto.response.AppointmentToPatientResponse;

public interface AppointmentService  extends CrudService<AppointmentRequest, AppointmentResponse, AppointmentToPatientResponse, Long> {
  
}
