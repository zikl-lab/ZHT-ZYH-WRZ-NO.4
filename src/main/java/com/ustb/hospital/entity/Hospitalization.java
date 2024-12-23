package com.ustb.hospital.entity;

public class Hospitalization {
    private int hospitalizationId;
    private int patientId;
    private String roomNumber;
    private int cost;
    private String paymentStatus;
    private String isInsured;
    private String hospitalizationStatus;

    public int getHospitalizationId() {
        return hospitalizationId;
    }

    public void setHospitalizationId(int hospitalizationId) {
        this.hospitalizationId = hospitalizationId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getIsInsured() {
        return isInsured;
    }

    public void setIsInsured(String isInsured) {
        this.isInsured = isInsured;
    }

    public String getHospitalizationStatus() {
        return hospitalizationStatus;
    }

    public void setHospitalizationStatus(String hospitalizationStatus) {
        this.hospitalizationStatus = hospitalizationStatus;
    }

    @Override
    public String toString() {
        return "Hospitalization{" +
                "hospitalizationId=" + hospitalizationId +
                ", patientId=" + patientId +
                ", roomNumber='" + roomNumber + '\'' +
                ", cost=" + cost +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", isInsured='" + isInsured + '\'' +
                ", hospitalizationStatus='" + hospitalizationStatus + '\'' +
                '}';
    }
}
