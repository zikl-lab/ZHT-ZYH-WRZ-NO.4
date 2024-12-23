package com.ustb.hospital.entity;

public class Patients {
    private int patientId;
    private String patientCard;
    private String patientPassword;
    private String patientName;
    private String patientAvatar;
    private String patientPhone;
    private String patientEmail;
    private Double patientBalance;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(String patientCard) {
        this.patientCard = patientCard;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAvatar() {
        return patientAvatar;
    }

    public void setPatientAvatar(String patientAvatar) {
        this.patientAvatar = patientAvatar;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public Double getPatientBalance() {
        return patientBalance;
    }

    public void setPatientBalance(Double patientBalance) {
        this.patientBalance = patientBalance;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientId=" + patientId +
                ", patientCard='" + patientCard + '\'' +
                ", patientPassword='" + patientPassword + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientAvatar='" + patientAvatar + '\'' +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientBalance=" + patientBalance +
                '}';
    }
}
