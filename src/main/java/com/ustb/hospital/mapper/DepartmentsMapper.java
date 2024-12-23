package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Departments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentsMapper {
    public Integer getMaxId();

    public Departments selectByName(String name);


    /*    INSERT INTO `hospitalbd`.`departments`
(`id`,`department_name`, `department_pid`, `department_level`, `department_path`, `department_description`)
    VALUES (#{departmentId},#{departmentName},#{departmentPid},#{departmentLevel},#{departmentPath},#{departmentDescription})*/

    public Integer insert(Departments departments);

    public Integer updateById(@Param("id")int id,@Param("name")String name,@Param("desc")String desc);

    public Departments selectById(@Param("id")int id);

    public List<Departments> selectAll();

    public List<Departments> selectFirstDept(@Param("level") int level);

    public List<Departments> selectSecondDeptByPid(@Param("pid") int pid);

    public void deleteById(@Param("id")int id);


}
