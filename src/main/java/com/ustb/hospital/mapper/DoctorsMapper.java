package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Consultation;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorsMapper {

    public Integer getMaxId();

    public List<Doctors> selectAll(@Param("doctorNumber")String doctorNumber, @Param("name")String name, @Param("deptId")int deptId);

    public List<Doctors> selectAllDoc();

    public Doctors selectByNumber(@Param("number")String number);

    public Integer insert(Doctors doctors);

    public void deleteById(@Param("id") int id);

    public Doctors selectById(int id);

    public Doctors selectByName(String name);

    public List<Doctors> selectinformationById(int id);

    public List<Doctors> selectinformationByName(String name);

    public int updateById(@Param("id")int id,@Param("doctorNumber")String doctorNumber,@Param("doctorPassword")String doctorPassword, @Param("doctorName")String doctorName ,@Param("doctorAvatar")String doctorAvatar,@Param("doctorPhone")String doctorPhone,@Param("doctorEmail")String doctorEmail, @Param("doctorIntion")String doctorIntion, @Param("doctorReFee")String doctorReFee, @Param("doctorEnData")String doctorEnData, @Param("doctorDeptId")int doctorDeptId, @Param("doctorProTitleId")int doctorProTitleId);



}
