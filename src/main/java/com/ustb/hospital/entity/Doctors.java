package com.ustb.hospital.entity;

public class Doctors {
    private int doctorId;
    private String doctorNumber;
    private String doctorPassword;
    private String doctorName;
    private String doctorAvatar;
    private String doctorPhone;
    private String doctorEmail;
    private String doctorIntion;
    private String doctorReFee;
    private String doctorEnData;
    private Integer doctorDeptId;
    private Integer doctorProTitleId;

    private Departments departments;

    private Protitles protitles;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorAvatar() {
        return doctorAvatar;
    }

    public void setDoctorAvatar(String doctorAvatar) {
        this.doctorAvatar = doctorAvatar;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorIntion() {
        return doctorIntion;
    }

    public void setDoctorIntion(String doctorIntion) {
        this.doctorIntion = doctorIntion;
    }

    public String getDoctorReFee() {
        return doctorReFee;
    }

    public void setDoctorReFee(String doctorReFee) {
        this.doctorReFee = doctorReFee;
    }

    public String getDoctorEnData() {
        return doctorEnData;
    }

    public void setDoctorEnData(String doctorEnData) {
        this.doctorEnData = doctorEnData;
    }

    public Integer getDoctorDeptId() {
        return doctorDeptId;
    }

    public void setDoctorDeptId(Integer doctorDeptId) {
        this.doctorDeptId = doctorDeptId;
    }

    public Integer getDoctorProTitleId() {
        return doctorProTitleId;
    }

    public void setDoctorProTitleId(Integer doctorProTitleId) {
        this.doctorProTitleId = doctorProTitleId;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Protitles getProtitles() {
        return protitles;
    }

    public void setProtitles(Protitles protitles) {
        this.protitles = protitles;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "doctorId=" + doctorId +
                ", doctorNumber='" + doctorNumber + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorAvatar='" + doctorAvatar + '\'' +
                ", doctorPhone='" + doctorPhone + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorIntion='" + doctorIntion + '\'' +
                ", doctorReFee='" + doctorReFee + '\'' +
                ", doctorEnData='" + doctorEnData + '\'' +
                ", doctorDeptId=" + doctorDeptId +
                ", doctorProTitleId=" + doctorProTitleId +
                ", departments=" + departments +
                ", protitles=" + protitles +
                '}';
    }
}
