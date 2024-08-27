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
public class PatientAppointmentResponse {
  
    private Long id;
   
    private String name;

    private int age;

    private String bloodType;
}
