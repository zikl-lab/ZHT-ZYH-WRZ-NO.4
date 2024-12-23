package com.ustb.hospital.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.ustb.hospital.entity.Hospitalization;
import com.ustb.hospital.mapper.HospitalizationMapper;
import com.ustb.hospital.utils.MybatisUtil;

import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class HospitalizationServiceImpl {
    public PageInfo<Hospitalization> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        HospitalizationMapper mapper = sqlSession.getMapper(HospitalizationMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<Hospitalization> list = mapper.selectAll();

        // 封装分页结果
        PageInfo<Hospitalization> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
    public void deleteDeptById(int hosId) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            HospitalizationMapper mapper = sqlSession.getMapper(HospitalizationMapper.class);
            mapper.deleteById(hosId);

        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(int hosId,int hosPId,String hosRoom,int hosCost,String hosPStatus,String hosInsured,String hosStatus) throws Exception{

        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            HospitalizationMapper mapper = sqlSession.getMapper(HospitalizationMapper.class);
            mapper.updateById(hosId,hosPId,hosRoom,hosCost,hosPStatus,hosInsured,hosStatus);
        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
        /*finally {
        }*/
    }
    public Hospitalization queryById(int hosId){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        HospitalizationMapper mapper = sqlSession.getMapper(HospitalizationMapper.class);

        // 使用 PageHelper 进行分页
        Hospitalization hospitalization= mapper.selectById(hosId);
        return hospitalization;
    }
    public List<Hospitalization> queryAllDept(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        HospitalizationMapper mapper = sqlSession.getMapper(HospitalizationMapper.class);
        List<Hospitalization> list =mapper.selectAll();
        return list;
    }
    public void save(int hosPId,String hosRoom,int hosCost,String hosPStatus,String hosInsured,String hosStatus) throws Exception{

        try {
            //验证病房是否空闲
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            HospitalizationMapper mapper = sqlSession.getMapper(HospitalizationMapper.class);
            Hospitalization hospitalization =mapper.selectByNumber(hosRoom);
            if(hospitalization == null){
                Hospitalization hospitalizationnew = new Hospitalization();
                Integer max=mapper.getMaxId();
                if(max ==null){
                    max = (Integer) 0;
                }
                hospitalizationnew.setHospitalizationId(max+1);
                hospitalizationnew.setPatientId(hosPId);
                hospitalizationnew.setRoomNumber(hosRoom);
                hospitalizationnew.setCost(hosCost);
                hospitalizationnew.setPaymentStatus(hosPStatus);
                hospitalizationnew.setIsInsured(hosInsured);
                hospitalizationnew.setHospitalizationStatus(hosStatus);
                //判斷級數
                mapper.insert(hospitalizationnew);
            }
            else
            {
                //科室名稱重複
                throw new Exception("病房已有预约!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
    }
}


