package com.taller_final_estructuras.domain.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column()
    private String name;

    @Column()
    private String specialty;

    @Column()
    private Boolean isActive;


    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

}
