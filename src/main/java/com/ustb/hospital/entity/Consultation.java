package com.ustb.hospital.entity;

import java.sql.Timestamp;

public class Consultation {
    private int consultationId;
    private int patientId;
    private int doctorId;
    private String consultationTime;
    private Integer isHospitalRegistered;
    private Integer isHospitalized;
    private String medicalAdviceCase;

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }


    public String getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(String consultationTime) {
        this.consultationTime = consultationTime;
    }

    public Integer getIsHospitalRegistered() {
        return isHospitalRegistered;
    }

    public void setIsHospitalRegistered(Integer isHospitalRegistered) {
        this.isHospitalRegistered = isHospitalRegistered;
    }

    public Integer getIsHospitalized() {
        return isHospitalized;
    }

    public void setIsHospitalized(Integer isHospitalized) {
        this.isHospitalized = isHospitalized;
    }

    public String getMedicalAdviceCase() {
        return medicalAdviceCase;
    }

    public void setMedicalAdviceCase(String medicalAdviceCase) {
        this.medicalAdviceCase = medicalAdviceCase;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "consultationId=" + consultationId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", consultationTime='" + consultationTime + '\'' +
                ", isHospitalRegistered=" + isHospitalRegistered +
                ", isHospitalized=" + isHospitalized +
                ", medicalAdviceCase='" + medicalAdviceCase + '\'' +
                '}';
    }
}
