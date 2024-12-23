package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.DoctorSchedules;
import com.ustb.hospital.mapper.DoctorSchedulesMapper;
import com.ustb.hospital.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class DoctorSchedulesServiceImpl {

   public List<DoctorSchedules> queryAllSchedules(){
       SqlSession sqlSession = MybatisUtil.getSqlSession();

       DoctorSchedulesMapper mapper = sqlSession.getMapper(DoctorSchedulesMapper.class);

       List<DoctorSchedules> list = mapper.selectAll();



        return  list;

   }


    public void save(int doctorId,String date,String time,Integer departmentId,int isAvailable,Integer visitCount,String remarks) throws Exception{

            //驗證科室名是否可用
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            DoctorSchedulesMapper mapper = sqlSession.getMapper(DoctorSchedulesMapper.class);
            DoctorSchedules doctorSchedulesNew = new DoctorSchedules();
            Integer max=mapper.getMaxId();
            if(max ==null){
                max = (Integer) 0;
            }
            doctorSchedulesNew.setScheduleId(max+1);

            doctorSchedulesNew.setDoctorId(doctorId);
            doctorSchedulesNew.setDate(date);
            doctorSchedulesNew.setShiftTime(time);
            doctorSchedulesNew.setDepartmentId(departmentId);
            doctorSchedulesNew.setIsAvailable(isAvailable);
            doctorSchedulesNew.setVisitCount(visitCount);
            doctorSchedulesNew.setRemarks(remarks);
            //判斷級數
            mapper.insert(doctorSchedulesNew);
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
        }*/
    }
public DoctorSchedules queryById(int scheduleId){
    SqlSession sqlSession = MybatisUtil.getSqlSession();

    // 获取 Mapper 对象
    DoctorSchedulesMapper mapper = sqlSession.getMapper(DoctorSchedulesMapper.class);

    // 使用 PageHelper 进行分页
    DoctorSchedules doctorSchedules = mapper.selectById(scheduleId);
    return doctorSchedules;
}


    public PageInfo<DoctorSchedules> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DoctorSchedulesMapper mapper = sqlSession.getMapper(DoctorSchedulesMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<DoctorSchedules> list = mapper.selectAll();

        // 封装分页结果
        PageInfo<DoctorSchedules> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    public void update(int scheduleId,int doctorId,String date,String shiftTime,Integer departmentId,int isAvailable,Integer visitCount,String remarks) throws Exception {

        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorSchedulesMapper mapper = sqlSession.getMapper(DoctorSchedulesMapper.class);
            mapper.updateById(scheduleId, doctorId, date, shiftTime,departmentId,isAvailable,visitCount,remarks);
        } catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
        /*finally {
        }*/
    }
    public void deleteScheduleById(int scheduleId) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorSchedulesMapper mapper = sqlSession.getMapper(DoctorSchedulesMapper.class);
            mapper.deleteById(scheduleId);

        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
    }
}
