package com.taller_final_estructuras.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taller_final_estructuras.domain.entities.Appointment;
import java.time.LocalDate;
import java.util.List;
public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {
  Appointment findLastByPatientId(Long patientId);

    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.date = :date")
    List<Appointment> findAppointmentsByDoctorAndDate(@Param("doctorId") Long doctorId, @Param("date") LocalDate date);
}
