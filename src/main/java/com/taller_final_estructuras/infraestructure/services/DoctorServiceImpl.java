package com.taller_final_estructuras.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller_final_estructuras.api.dto.request.DoctorRequest;
import com.taller_final_estructuras.api.dto.response.DoctorResponse;
import com.taller_final_estructuras.domain.entities.Doctor;
import com.taller_final_estructuras.domain.repositories.DoctorRepository;
import com.taller_final_estructuras.infraestructure.abstract_services.DoctorService;
import com.taller_final_estructuras.infraestructure.mappers.DoctorMapper;

@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private DoctorMapper doctorMapper;

  @Override
  public DoctorResponse create(DoctorRequest rq) {
    Doctor doctor = doctorMapper.toEntity(rq);
    doctorRepository.save(doctor);
    return doctorMapper.toResponse(doctor);

  }

  @Override
  public void delete(Long id) {
    this.doctorRepository.deleteById(id);

  }

  @Override
  public List<DoctorResponse> findAll() {

    return this.doctorRepository.findAll().stream().map(doctorMapper::toResponse).toList();
  }

  @Override
  public DoctorResponse findById(Long id) {

    return this.doctorRepository.findById(id).map(doctorMapper::toResponse).orElse(null);
  }

  @Override
  public DoctorResponse update(DoctorRequest rq, Long id) {
    Doctor doctor = this.doctorRepository.findById(id).orElse(null);
    if (doctor == null) {
      return null;
    }
    doctor.setName(rq.getName());
    doctor.setSpecialty(rq.getSpecialty());
    doctorRepository.save(doctor);
    return doctorMapper.toResponse(doctor);

  }

}
