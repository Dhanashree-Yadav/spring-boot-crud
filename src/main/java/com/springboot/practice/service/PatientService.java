package com.springboot.practice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practice.dto.PatientRequest;
import com.springboot.practice.model.Patient;
import com.springboot.practice.repository.PatientRepository;

@Service
public class PatientService {
	private static final Logger loggerInfo = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	private PatientRepository patientRepo;

	public Patient createPatient(PatientRequest patientRequest) {

		Patient patient1 = new Patient();

		patient1.setFirstname(patientRequest.getFirstname());
		patient1.setMiddlename(patientRequest.getMiddlename());
		patient1.setLastname(patientRequest.getLastname());
		patient1.setDob(patientRequest.getDob());
		patient1.setAddress1(patientRequest.getAddress1());
		patient1.setAddress2(patientRequest.getAddress2());
		patient1.setLandmark(patientRequest.getLandmark());
		patient1.setCity(patientRequest.getCity());
		patient1.setZipcode(patientRequest.getZipcode());
		patient1.setEmail(patientRequest.getEmail());
		patient1.setMobile(patientRequest.getMobile());
		patientRepo.save(patient1);

		loggerInfo.info("patient Id " + patient1.getId() + " is created");
		return patient1;

	}

	
	public List<PatientRequest> getAllPatient()
	{
		List<Patient> patient1 = patientRepo.findAll();
		return patient1.stream()
				.map(this::mapToRequest)
				.collect(Collectors.toList());
	}
	private PatientRequest mapToRequest(Patient patient2) {
		PatientRequest request = new PatientRequest();
		request.setFirstname(patient2.getFirstname());
		request.setMiddlename(patient2.getMiddlename());
		request.setLastname(patient2.getLastname());
		request.setDob(patient2.getDob());
		request.setAddress1(patient2.getAddress1());
		request.setAddress2(patient2.getAddress2());
		request.setLandmark(patient2.getLandmark());
		request.setCity(patient2.getCity());
		request.setZipcode(patient2.getZipcode());
		request.setEmail(patient2.getEmail());
		request.setMobile(patient2.getMobile());
		return request;
	}


	public Optional<PatientRequest> getPatientById(UUID id) {
		Optional<Patient> patient1 = patientRepo.findById(id);
		
		if(patient1.isPresent()) {
			Patient patient2 =patient1.get();
			
			
			PatientRequest patientRequest = new PatientRequest();
			
			patientRequest.setFirstname(patient2.getFirstname());
			patientRequest.setMiddlename(patient2.getMiddlename());
			patientRequest.setLastname(patient2.getLastname());
			patientRequest.setDob(patient2.getDob());
			patientRequest.setAddress1(patient2.getAddress1());
			patientRequest.setAddress2(patient2.getAddress2());
			patientRequest.setLandmark(patient2.getLandmark());
			patientRequest.setCity(patient2.getCity());
			patientRequest.setZipcode(patient2.getZipcode());
			patientRequest.setEmail(patient2.getEmail());
			patientRequest.setMobile(patient2.getMobile());
			
			return Optional.of(patientRequest);
		}
		else
			
		return Optional.empty();
	}


	public String deletePatientById(UUID id) {
		Optional<Patient> patient = patientRepo.findById(id);
		if(patient.isPresent())
		{
			patientRepo.deleteById(id);
			
		}
		return "Record deleted for "+id;
	}
}
