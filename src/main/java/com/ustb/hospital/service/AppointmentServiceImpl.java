package com.ustb.hospital.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.ustb.hospital.entity.Appointment;
import com.ustb.hospital.entity.DoctorSchedules;
import com.ustb.hospital.mapper.AppointmentMapper;
import com.ustb.hospital.utils.MybatisUtil;

import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class AppointmentServiceImpl {
    public PageInfo<Appointment> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<Appointment> list = mapper.selectAll();

        // 封装分页结果
        PageInfo<Appointment> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
    public void deleteDeptById(int deptId) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);
            mapper.deleteById(deptId);

        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(int appointId,int appointPId,int appointDId,String appointData,String appointTime,String appointStatus) throws Exception{

        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);
            mapper.updateById(appointId,appointPId,appointDId,appointData,appointTime,appointStatus);
        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
        /*finally {
        }*/
    }
    public Appointment queryById(int appointId){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);

        // 使用 PageHelper 进行分页
        Appointment appointment= mapper.selectById(appointId);
        return appointment;
    }
    public List<Appointment> queryAllDept(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);
        List<Appointment> list =mapper.selectAll();
        return list;
    }
    public void save(int appointPId,int appointDId,String appointDate,String appointTime,String status) throws Exception{

        try {
            //验证医生是否空闲
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);
            Appointment appointmentNew = new Appointment();
            Integer max=mapper.getMaxId();
            if(max ==null){
                max = (Integer) 0;
            }
            appointmentNew.setAppointmentId(max+1);
            appointmentNew.setPatientId(appointPId);
            appointmentNew.setDoctorId(appointDId);
            appointmentNew.setAppointmentDate(appointDate);
            appointmentNew.setAppointmentTime(appointTime);
            appointmentNew.setStatus(status);
            //判斷級數
            mapper.insert(appointmentNew);
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
        }*/

    }

    public PageInfo<DoctorSchedules> queryBeforeByDid(int doctorId ,int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<DoctorSchedules> list = mapper.selectBeforeByDid(doctorId);

        // 封装分页结果
        PageInfo<DoctorSchedules> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;

    }



}
