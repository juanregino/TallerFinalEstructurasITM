package com.taller_final_estructuras.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller_final_estructuras.domain.entities.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Long> {
  
}
