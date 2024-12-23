package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Protitles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProtitlesMapper {
    public Integer getMaxId();

    public List<Protitles> selectAll();

    public Protitles selectById(@Param("id")int id);

    public Protitles selectByName(String name);

    public Integer insert(Protitles protitles);

    public Integer updateById(@Param("id")int id, @Param("name")String name, @Param("desc")String desc);

    public void deleteById(@Param("id")int id);
}
