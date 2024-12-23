package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Admins;
import com.ustb.hospital.entity.Protitles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminsMapper {
    Admins selectByUsername(@Param("username")String username);
    public Integer updateById(@Param("adminId")int adminId, @Param("password")String password);
    public Admins selectById(@Param("adminId")int adminId);
    public List<Admins> selectAll();

    public String getPassword(@Param("adminId")int adminId);
}
