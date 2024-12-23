package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.DoctorSchedules;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorSchedulesMapper {
    List<DoctorSchedules> selectAll();

    public Integer updateById(@Param("scheduleId") int scheduleId,
                              @Param("doctorId") int doctorId,
                              @Param("date") String date,
                              @Param("shiftTime") String shiftTime,
                              @Param("departmentId") Integer departmentId,
                              @Param("isAvailable") int isAvailable,
                              @Param("visitCount") Integer visitCount,
                              @Param("remarks") String remarks);

    public DoctorSchedules selectById(int scheduleId);

    public void deleteById(int scheduleId);



    public Integer getMaxId();

    public Integer insert(DoctorSchedules doctorSchedules);

    public DoctorSchedules selectByDoctor(int doctorId);

}
