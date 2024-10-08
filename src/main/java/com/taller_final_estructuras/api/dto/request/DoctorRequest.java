package com.taller_final_estructuras.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequest {
  
  private String name;

  private String specialty;

  private Boolean isActive;
}
