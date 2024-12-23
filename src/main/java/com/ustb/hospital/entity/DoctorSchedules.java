package com.ustb.hospital.entity;

public class DoctorSchedules {
    private int scheduleId;

    private int doctorId;

    private String date;

    private String shiftTime;

    private Integer departmentId;

    private int isAvailable;

    private Integer visitCount;

    private String remarks;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "DoctorSchedules{" +
                "scheduleId=" + scheduleId +
                ", doctorId=" + doctorId +
                ", date='" + date + '\'' +
                ", shiftTime='" + shiftTime + '\'' +
                ", departmentId=" + departmentId +
                ", isAvailable=" + isAvailable +
                ", visitCount=" + visitCount +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
