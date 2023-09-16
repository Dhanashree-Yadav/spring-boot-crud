package com.springboot.practice.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practice.dto.PatientRequest;
import com.springboot.practice.model.Patient;
import com.springboot.practice.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Patient createPatient(@RequestBody PatientRequest patient) {
		return patientService.createPatient(patient);	
	}
	
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<PatientRequest> getAllPatient() {
		return patientService.getAllPatient();	
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<PatientRequest> getPatientById(@PathVariable("id") UUID id) {
		return patientService.getPatientById(id);
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deletePatientById(@PathVariable("id")UUID id) {
		return patientService.deletePatientById(id);
		}
}
