package com.ustb.hospital.mapper;


import com.ustb.hospital.entity.Hospitalization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HospitalizationMapper {
    public List<Hospitalization> selectAll();
    public void deleteById(@Param("id")int id);
    public Integer updateById(@Param("id") int id, @Param("pid") int pid, @Param("hosRoom") String hosRoom, @Param("cost") int cost, @Param("paymentstatus") String paymentstatus, @Param("isinsured") String isinsured, @Param("hospitalizationstatus") String hospitalizationstatus);
    public Hospitalization selectById(@Param("id")int id);
    public Hospitalization selectByNumber(String number);
    public Integer getMaxId();
    public Integer insert(Hospitalization hospitalization);
}
