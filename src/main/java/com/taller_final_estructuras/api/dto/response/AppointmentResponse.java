package com.taller_final_estructuras.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponse {
  
    private Long id;
   
    private String description;

    private String date;

    private PatientAppointmentResponse patient;

    private DoctorResponse doctor;
}
