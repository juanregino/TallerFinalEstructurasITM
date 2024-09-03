package com.taller_final_estructuras.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller_final_estructuras.api.dto.request.AppointmentRequest;
import com.taller_final_estructuras.api.dto.response.AppointmentResponse;
import com.taller_final_estructuras.api.dto.response.PatientResponse;
import com.taller_final_estructuras.infraestructure.abstract_services.AppointmentService;

@RestController
@RequestMapping("appointments")
public class AppointMentController {
  @Autowired
  private AppointmentService appointmentService;
 
  @PostMapping
  public ResponseEntity<List<PatientResponse>> createAllAppointments(){ 
    return ResponseEntity.ok(appointmentService.createAppointmentsForAllPatients());
  }
}
