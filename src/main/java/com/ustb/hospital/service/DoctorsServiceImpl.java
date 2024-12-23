package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.*;
import com.ustb.hospital.mapper.*;
import com.ustb.hospital.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DoctorsServiceImpl {

    public PageInfo<Doctors> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<Doctors> list = mapper.selectAllDoc();

        // 封装分页结果
        PageInfo<Doctors> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    public PageInfo<Doctors> queryByPage(int pageNum, int pageSize, String doctorNumber, String name, int deptId){
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 获取 Mapper 对象
        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<Doctors> list = mapper.selectAll(doctorNumber, name, deptId);

        // 封装分页结果
        PageInfo<Doctors> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }

    public List<Doctors> queryAllDoc() {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        List<Doctors> list =mapper.selectAllDoc();
        return list;
    }

    public PageInfo<Doctors> queryoneDoc(String name,int pageNum,int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        PageHelper.startPage(pageNum, pageSize);
        List<Doctors> list =mapper.selectinformationByName(name);

        // 封装分页结果
        PageInfo<Doctors> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    public List<Departments> queryAllDept() {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        List<Departments> list =mapper.selectAll();
        return list;
    }

    public List<Departments> querySecondDept() {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);

        List<Departments> list =mapper.selectFirstDept(2);
        return list;
    }

    public List<Protitles> queryAllProt() {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 获取 Mapper 对象
        ProtitlesMapper mapper = sqlSession.getMapper(ProtitlesMapper.class);
        List<Protitles> list = mapper.selectAll();
        return list;
    }

    public Doctors queryByNumber(String doctorNumber){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);

        Doctors doctors = mapper.selectByNumber(doctorNumber);

        return doctors;
    }

    public void save(String doctorNumber,String doctorPassword,String doctorName,String doctorAvatar,String doctorPhone,String doctorEmail,String doctorIntion,String doctorReFee,String doctorEnData,int doctorDeptId ,int doctorProTitleId) throws Exception{


        try {
            //驗證科室名是否可用
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
            Doctors patients = mapper.selectByNumber(doctorNumber);
            if (patients == null) {
                Doctors doctorNew = new Doctors();
                Integer max=mapper.getMaxId();
                if(max ==null){
                    max = (Integer) 0;
                }
                doctorNew.setDoctorId((int)max + 1);
                doctorNew.setDoctorNumber(doctorNumber);
                doctorNew.setDoctorPassword(doctorPassword);
                doctorNew.setDoctorName(doctorName);
                doctorNew.setDoctorAvatar(doctorAvatar);
                doctorNew.setDoctorPhone(doctorPhone);
                doctorNew.setDoctorEmail(doctorEmail);
                doctorNew.setDoctorIntion(doctorIntion);
                doctorNew.setDoctorReFee(doctorReFee);
                doctorNew.setDoctorEnData(doctorEnData);
                doctorNew.setDoctorDeptId(doctorDeptId);
                doctorNew.setDoctorProTitleId(doctorProTitleId);
                mapper.insert(doctorNew);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
        }*/
    }

    public int delete(int id){
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            DoctorsMapper mapper = sqlSession.getMapper( DoctorsMapper.class);
            List<Doctors> list =mapper.selectinformationById(id);
            if (list == null) {
                mapper.deleteById(id);
                return 1;
            }
            else {
                mapper.deleteById(id);
                System.out.println("全部刪除！");
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //释放资源
        }
    }


    public void update(int id,String jobNum, String password,String name,String avatar,String phone, String email,String intro,String fee,String date,int departmentId,int professionalTitleId){
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            DoctorsMapper mapper = sqlSession.getMapper( DoctorsMapper.class);
            mapper.updateById(id,jobNum,password,name,avatar,phone,email,intro,fee,date,departmentId,professionalTitleId);
        } catch (Exception e) {
            throw new RuntimeException(e);


        }finally {
            //释放资源
        }
    }
    public Doctors queryById(int id){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        Doctors doctors = mapper.selectById(id);
        return doctors;
    }
}
