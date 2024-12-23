package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.mapper.DepartmentsMapper;
import com.ustb.hospital.mapper.DoctorsMapper;
import com.ustb.hospital.mapper.PatientsMapper;
import com.ustb.hospital.mapper.ProtitlesMapper;
import com.ustb.hospital.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class PatientsServiceImpl {
    public PageInfo<Patients> queryonePat(String name,int pageNum,int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        PageHelper.startPage(pageNum, pageSize);
        List<Patients> list =mapper.selectinformationByName(name);

        // 封装分页结果
        PageInfo<Patients> pageInfo = new PageInfo(list);

        return pageInfo;
    }

    public Patients queryByCard(String patientCard){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);

        Patients patients = mapper.selectByCard(patientCard);

        return patients;
    }

    public Patients queryById(int patientId){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);

        Patients patients = mapper.selectById(patientId);

        return patients;
    }

    public Patients queryByPhone(String patientPhone){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);

        Patients patients = mapper.selectByPhone(patientPhone);

        return patients;
    }

    public List<Patients> queryAllPat() {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 获取 Mapper 对象
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        List<Patients> list = mapper.selectAll();
        return list;
    }
    public Patients queryByName(String patientName){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);

        Patients patients = mapper.selectByName(patientName);

        return patients;
    }
    public PageInfo<Patients> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<Patients> list = mapper.selectAll();

        // 封装分页结果
        PageInfo<Patients> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;

    }


    public void save(String patCard,String patPassword,String patName,String patAvatar,String patPhone,String patEmail,Double patBalance) throws Exception {

        try {
            //驗證科室名是否可用
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
            Patients patients = mapper.selectByCard(patCard);
            if (patients == null) {
                Patients patientsNew = new Patients();
                Integer max=mapper.getMaxId();
                if(max ==null){
                    max = (Integer) 1;
                }
                patientsNew.setPatientId((int)max + 1);
                patientsNew.setPatientCard(patCard);
                patientsNew.setPatientPassword(patPassword);
                patientsNew.setPatientName(patName);
                patientsNew.setPatientAvatar(patAvatar);
                patientsNew.setPatientPhone(patPhone);
                patientsNew.setPatientEmail(patEmail);
                patientsNew.setPatientBalance(patBalance);
                mapper.insert(patientsNew);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
    public void deleteDeptById(int patId) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
            mapper.deleteById(patId);

        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Patients> queryFirstDept(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        List<Patients> list =mapper.selectFirstDept(1);
        return list;
    }
    public void update(int patientId,String patientIdCard,String patientPassword,String patientName,String doctorAvatar,String patientPhone,String patientEmail,Double patientBalance) throws Exception{

        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
                mapper.updateById(patientId,patientIdCard,patientPassword,patientName,doctorAvatar,patientPhone,patientEmail,patientBalance);


        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
        /*finally {
        }*/
    }
}
