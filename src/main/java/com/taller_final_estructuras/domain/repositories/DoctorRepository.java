package com.taller_final_estructuras.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taller_final_estructuras.domain.entities.Doctor;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
  @Query("SELECT d FROM Doctor d WHERE d.isActive = true")
  List<Doctor> findActiveDoctors();
}
