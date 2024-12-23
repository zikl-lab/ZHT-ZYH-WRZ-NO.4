package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Consultation;
import com.ustb.hospital.entity.Departments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsultationMapper {

    List<Consultation> selectAll();

    public Integer getMaxId();

    List<Consultation> selectByPatId(int patientId);

    public Integer insert(Consultation consultation);

    public Consultation selectById(int id);

    public void deleteById(@Param("id")int id);

    public int updateById(@Param("id")int id,@Param("patid")int patid, @Param("docid")int docid ,@Param("time")String time,@Param("ishr")Integer ishr,@Param("ishd")Integer ishd, @Param("mac")String mac);
    /*    int deleteById(int id);

        int add(Departments departments);

        int updateById(@Param("id") int id,@Param("location") String location);*/

    List<Consultation> selectinformationById(int pid);
}
