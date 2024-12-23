package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.entity.Protitles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientsMapper {
    public Integer getMaxId();

    public List<Patients> selectAll();

    public Patients selectById(@Param("id")int id);

    public Patients selectByCard(@Param("card")String card);

    public Patients selectByPhone(@Param("phone")String phone);

    public Integer insert(Patients patients);
    public List<Patients> selectinformationByName(String name);

    public void deleteById(@Param("id")int id);
    public List<Patients> selectFirstDept(@Param("level") int level);
    public Patients selectByName(String name);
    public Integer updateById(@Param("id")int id,@Param("number")String number,@Param("password")String password,@Param("name")String name,@Param("avatar")String avatar,@Param("phone")String phone,@Param("email")String email,@Param("balance")Double balance);
}
