package com.springboot.practice.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.practice.dto.PatientRequest;
import com.springboot.practice.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID>{

	Optional<Patient> findById(UUID id);

	
}
