package com.hcl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.DoctorInfo;
import com.hcl.repository.DoctorInfoRepository;


@Service
public class DoctorInfoService {

	@Autowired
	DoctorInfoRepository doctorInfoRepository;
	
	public String addDoctorInfo(DoctorInfo doctor) {
		doctorInfoRepository.save(doctor);
		
		return "Doctor record added Successfully";
		
	}

	public DoctorInfo getDoctorById(String doctorId) {
		
		Optional<DoctorInfo> doctor = doctorInfoRepository.findById(doctorId);
		
		if(doctor.isPresent()) {
			return doctor.get();
		}
		return null;
		
	}
}
