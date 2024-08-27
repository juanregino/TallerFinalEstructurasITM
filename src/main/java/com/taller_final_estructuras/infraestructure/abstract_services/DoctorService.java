package com.taller_final_estructuras.infraestructure.abstract_services;

import com.taller_final_estructuras.api.dto.request.DoctorRequest;
import com.taller_final_estructuras.api.dto.response.DoctorResponse;

public interface DoctorService extends CrudService<DoctorRequest, DoctorResponse, DoctorResponse, Long> {
  
}
