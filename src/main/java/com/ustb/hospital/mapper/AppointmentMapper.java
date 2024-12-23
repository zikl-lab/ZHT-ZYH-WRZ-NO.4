package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Appointment;
import com.ustb.hospital.entity.DoctorSchedules;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentMapper {
    public List<Appointment> selectAll();
    public void deleteById(@Param("id")int id);
    public Integer updateById(@Param("id") int id, @Param("pid") int pid, @Param("cost") int cost, @Param("pstatus") String pstatus, @Param("insured") String insured, @Param("status") String status);
    public Appointment selectById(@Param("id")int id);
    public Appointment selectByName(int name);
    public Integer getMaxId();
    public Integer insert(Appointment appointment);
    public List<DoctorSchedules> selectBeforeByDid(@Param("doctorId") int doctorId);
    public List<DoctorSchedules> selectBefore();

}
