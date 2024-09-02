package com.taller_final_estructuras.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller_final_estructuras.api.dto.request.DoctorRequest;
import com.taller_final_estructuras.api.dto.response.DoctorResponse;
import com.taller_final_estructuras.infraestructure.abstract_services.DoctorService;



@RestController
@RequestMapping("doctor")
public class DoctorController {
  @Autowired
  private DoctorService doctorService;

  @PostMapping
  public ResponseEntity<DoctorResponse> createDoctor(@RequestBody DoctorRequest doctor) {
    return ResponseEntity.ok(doctorService.create(doctor));
  }

  @GetMapping
  public ResponseEntity<List<DoctorResponse>> getDoctors() {
    return ResponseEntity.ok(doctorService.findAll());
  }


  @GetMapping("/{id}")
  public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable Long id) {
    return ResponseEntity.ok(doctorService.findById(id));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<DoctorResponse> updateDoctor(@PathVariable Long id ,@RequestBody DoctorRequest doctor) {
    return ResponseEntity.ok(doctorService.update(doctor, id));
  }
}
