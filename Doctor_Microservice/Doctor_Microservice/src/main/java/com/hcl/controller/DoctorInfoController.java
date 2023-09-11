package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.entity.DoctorInfo;
import com.hcl.service.DoctorInfoService;
import com.hcl.to.AppointmentTO;
import com.hcl.to.DiagnosisInfo;
import com.hcl.to.PatientInfo;


@RestController
@RequestMapping("/DoctorInfo")
public class DoctorInfoController {

	@Autowired
	DoctorInfoService doctorInfoService;
	
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/addDetails")
	public String addDoctorInfo(@RequestBody DoctorInfo doctor) {

		String recordaddStatus = doctorInfoService.addDoctorInfo(doctor);

		return recordaddStatus;
	}
	
	@GetMapping("/getDoctorDetails/{doctorId}")
		public DoctorInfo getDoctorById(@PathVariable String doctorId) {
		
		DoctorInfo doctor = doctorInfoService.getDoctorById(doctorId);
		
		return doctor;
		
	}
	@GetMapping("/appointment/{patientId}/findDiagnosis/{diagnosisId}")
	public AppointmentTO appointment(@PathVariable String patientId, @PathVariable String diagnosisId ) {
		PatientInfo patient = restTemplate.getForObject("http://localhost:8081/PatientInfo/findPatientById/" + patientId, PatientInfo.class);
		System.out.println("Patient data is "+ patient.getPatientId()+ ","+ patient.getPatientName()+ "," + patient.getEmail()+ "," + patient.getIllness());
		
		DiagnosisInfo diagnosis = restTemplate.getForObject("http://localhost:8082/DiagnosisInfo/getDiagnosis/" + diagnosisId, DiagnosisInfo.class);
		System.out.println("Diagnosis data is "+ diagnosis.getDiagnosisId()+ ","+ diagnosis.getDoctorId()+ "," + diagnosis.getDiseaseName());
		
		AppointmentTO appointmentTO = new AppointmentTO(patient, diagnosis);
		
		return appointmentTO;
		
	}
}
