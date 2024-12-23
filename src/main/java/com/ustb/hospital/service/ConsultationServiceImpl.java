package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Consultation;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.mapper.ConsultationMapper;
import com.ustb.hospital.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ConsultationServiceImpl {

    public void save(int patid, int docid, String time,Integer ishr,Integer ishd, String mac) throws Exception {
        try {
            //验证科室名是否可用
            // 调用工具类获取 SqlSession
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            ConsultationMapper mapper = sqlSession.getMapper(ConsultationMapper.class);
            Consultation consultationNew = new Consultation();
            Integer max=mapper.getMaxId();
            if(max ==null){
                max = (Integer) 0;
            }
            consultationNew.setConsultationId((int)max + 1);
            consultationNew.setPatientId(patid);
            consultationNew.setDoctorId(docid);
            consultationNew.setConsultationTime(time);
            consultationNew.setIsHospitalRegistered(ishr);
            consultationNew.setIsHospitalized(ishd);
            consultationNew.setMedicalAdviceCase(mac);
            mapper.insert(consultationNew);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

        public int delete(int deptId){
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            ConsultationMapper mapper = sqlSession.getMapper(ConsultationMapper.class);
            List<Consultation> list =mapper.selectinformationById(deptId);
            if (list == null) {
                mapper.deleteById(deptId);
                return 1;
            }
            else {
                mapper.deleteById(deptId);
                System.out.println("全部刪除！");
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //释放资源
        }
    }


    public void update(int id,int patid, int docid,String time,Integer ishr,Integer ishd, String mac){
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            ConsultationMapper mapper = sqlSession.getMapper(ConsultationMapper.class);
            mapper.updateById(id,patid,docid,time,ishr,ishd, mac);
        } catch (Exception e) {
            throw new RuntimeException(e);


        }finally {
            //释放资源
        }
    }

    public Consultation queryById(int id){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        ConsultationMapper mapper = sqlSession.getMapper(ConsultationMapper.class);
        Consultation consultation = mapper.selectById(id);
        return consultation;
    }



    public List<Consultation> queryFirstAll()
    {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        ConsultationMapper mapper = sqlSession.getMapper(ConsultationMapper.class);
        List<Consultation> list = mapper.selectAll();
        return list;
    }

    public PageInfo<Consultation> queryByPatientId(int id,int pageNum, int pageSize){
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        ConsultationMapper mapper = sqlSession.getMapper(ConsultationMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        //  List<Departments> list = mapper.selectAll();
        List<Consultation> list = mapper.selectByPatId(id);

        // 封装分页结果
        PageInfo<Consultation> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public PageInfo<Consultation> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        ConsultationMapper mapper = sqlSession.getMapper(ConsultationMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        //  List<Departments> list = mapper.selectAll();
        List<Consultation> list = mapper.selectAll();

        // 封装分页结果
        PageInfo<Consultation> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;

    }

}
