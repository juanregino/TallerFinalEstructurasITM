package com.taller_final_estructuras.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller_final_estructuras.api.dto.request.PatientRequest;
import com.taller_final_estructuras.api.dto.response.PatientAppointmentResponse;
import com.taller_final_estructuras.api.dto.response.PatientResponse;
import com.taller_final_estructuras.infraestructure.abstract_services.PatientService;


@RestController
@RequestMapping("patients")
public class PatientController {
  
  @Autowired
  private PatientService patientService;
@PostMapping
  public ResponseEntity<PatientAppointmentResponse> createPatient( @RequestBody PatientRequest patient) {
    return ResponseEntity.ok(patientService.create(patient));
  }

  @GetMapping
  public ResponseEntity<List<PatientResponse>> getPatients() {
    return ResponseEntity.ok(patientService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long id) {
    return ResponseEntity.ok(patientService.findById(id));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<PatientAppointmentResponse> updatePatient(@PathVariable Long id ,@RequestBody PatientRequest patient) {
    return ResponseEntity.ok(patientService.update(patient, id));
  }
}
