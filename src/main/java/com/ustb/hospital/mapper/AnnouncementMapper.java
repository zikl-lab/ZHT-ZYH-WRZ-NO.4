package com.ustb.hospital.mapper;


import com.ustb.hospital.entity.Announcement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnouncementMapper {
    public Integer getMaxId();

    public Announcement selectByTitle(String title);

    public Integer insert(Announcement announcement);

    public Integer updateById(@Param("id") int id,@Param("title") String title,  @Param("content") String content, @Param("creationTime") String creationTime, @Param("creator") String creator);

    public Announcement selectById(int id);

    public List<Announcement> selectAll();


    public void deleteById(int id);



}
