package com.taller_final_estructuras.infraestructure.services;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller_final_estructuras.api.dto.response.PatientResponse;
import com.taller_final_estructuras.domain.entities.Appointment;
import com.taller_final_estructuras.domain.entities.Doctor;
import com.taller_final_estructuras.domain.entities.Patient;
import com.taller_final_estructuras.domain.repositories.AppointmentRepository;
import com.taller_final_estructuras.domain.repositories.DoctorRepository;
import com.taller_final_estructuras.domain.repositories.PatientRepository;
import com.taller_final_estructuras.infraestructure.abstract_services.AppointmentService;
import com.taller_final_estructuras.infraestructure.mappers.AppointmentMapper;
import com.taller_final_estructuras.infraestructure.mappers.PatientMapper;
import java.util.ArrayList;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    // Repositories and mappers should be autowired or injected accordingly
    @Autowired
    private PatientRepository patientRepository;
    @Autowired 
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;


       
  
@Override
    // Método que crea citas para todos los pacientes registrados
    public List<PatientResponse> createAppointmentsForAllPatients() {
        // Obtiene todos los pacientes de la base de datos
        List<Patient> patients = patientRepository.findAll();

        // Lista para almacenar las respuestas de los pacientes
        List<PatientResponse> patientResponses = new ArrayList<>();

        // Itera sobre cada paciente para crear la cita
        for (Patient patient : patients) {
            int age = patient.getAge();
            String bloodType = patient.getBloodType();
            Appointment lastAppointment = appointmentRepository.findLastByPatientId(patient.getId());

            // Calcula la próxima cita en función de la edad del paciente
            LocalDate nextAppointmentDate = calculateNextAppointmentDate(age, lastAppointment);

            // Busca un doctor disponible
            Doctor doctor = findAvailableDoctor(nextAppointmentDate);

            // Crea la cita si hay un doctor disponible
            if (doctor != null) {
                Appointment appointment = Appointment.builder()
                        .description("Nueva cita")
                        .date(nextAppointmentDate)
                        .patient(patient)
                        .doctor(doctor)
                        .build();

                appointmentRepository.save(appointment);
            }

            // Mapea la respuesta del paciente y la agrega a la lista de respuestas
            PatientResponse response = this.toResponse(patient);
            response.setAge(age);
            response.setBloodType(bloodType);
            response.setNextAppointmentDate(nextAppointmentDate);

            patientResponses.add(response);
        }

        return patientResponses;
    }
    
    
    // Determine the next appointment date based on the patient's age
    private LocalDate calculateNextAppointmentDate(int age, Appointment lastAppointment) {
        LocalDate nextDate = LocalDate.now();

        // Add intervals based on age
        if (age >= 25 && age <= 35) {
            nextDate = lastAppointment.getDate().plusMonths(2).plusDays(15);
        } else if (age > 35 && age <= 45) {
            nextDate = lastAppointment.getDate().plusMonths(1).plusDays(15);
        } else if (age > 45) {
            nextDate = lastAppointment.getDate().plusDays(15);
        }

        return nextDate;
    }

    // Find an available doctor for the specified date
    private Doctor findAvailableDoctor(LocalDate date) {
        // Query active doctors and check their availability
        List<Doctor> availableDoctors = doctorRepository.findActiveDoctors();

        for (Doctor doctor : availableDoctors) {
            boolean isAvailable = checkDoctorAvailability(doctor, date);
            if (isAvailable) {
                return doctor;
            }
        }

        // Return null if no doctor is available
        return null;
    }

    // Check the doctor's availability on the given date
    private boolean checkDoctorAvailability(Doctor doctor, LocalDate date) {
        // Check for conflicts with existing appointments
        List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctorAndDate(doctor.getId(), date);
        return appointments.isEmpty();
    }

    private PatientResponse toResponse ( Patient patient ) {
        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .age(patient.getAge())
                .bloodType(patient.getBloodType())
                .appointments(patient.getAppointments().stream().map(appointmentMapper::toAppointmentToPatientResponse).toList())
                .build();
    }
}
