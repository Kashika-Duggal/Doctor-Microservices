package com.hcl.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AppointmentTO {
	
	PatientInfo patientInfo;
	DiagnosisInfo diagnosisInfo;
	public AppointmentTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentTO(PatientInfo patient, DiagnosisInfo diagnosisInfo) {
		super();
		this.patientInfo = patient;
		this.diagnosisInfo = diagnosisInfo;
	}
	public PatientInfo getPatientInfo() {
		return patientInfo;
	}
	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}
	public DiagnosisInfo getDiagnosisInfo() {
		return diagnosisInfo;
	}
	public void setDiagnosisInfo(DiagnosisInfo diagnosisInfo) {
		this.diagnosisInfo = diagnosisInfo;
	}
	
	

}
