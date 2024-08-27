package com.taller_final_estructuras.api.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
   

  private String description;

  private LocalDate date;

  private Long patientId;

  private Long doctorId;
}
