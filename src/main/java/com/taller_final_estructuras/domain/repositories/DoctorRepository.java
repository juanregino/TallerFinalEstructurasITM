package com.taller_final_estructuras.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller_final_estructuras.domain.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
  
}
