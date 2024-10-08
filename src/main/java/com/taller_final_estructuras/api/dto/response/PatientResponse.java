package com.taller_final_estructuras.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {
  private Long id;
  
  private String name;

  private int age;

  private String bloodType; 

  private LocalDate nextAppointmentDate;

  private List<AppointmentToPatientResponse> appointments;
}
