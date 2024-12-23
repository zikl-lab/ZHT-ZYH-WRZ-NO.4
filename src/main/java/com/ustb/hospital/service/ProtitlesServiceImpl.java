package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.mapper.DepartmentsMapper;
import com.ustb.hospital.mapper.ProtitlesMapper;
import com.ustb.hospital.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class ProtitlesServiceImpl {

    public Protitles queryByName(String protitleName){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        ProtitlesMapper mapper = sqlSession.getMapper(ProtitlesMapper.class);

        Protitles protitles = mapper.selectByName(protitleName);

        return protitles;
    }

    public Protitles queryById(int protitleId){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        ProtitlesMapper mapper = sqlSession.getMapper(ProtitlesMapper.class);

        Protitles protitles = mapper.selectById(protitleId);

        return protitles;
    }

    public List<Protitles> queryAllProt() {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 获取 Mapper 对象
        ProtitlesMapper mapper = sqlSession.getMapper(ProtitlesMapper.class);
        List<Protitles> list = mapper.selectAll();
        return list;
    }

    public PageInfo<Protitles> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 获取 Mapper 对象
        ProtitlesMapper mapper = sqlSession.getMapper(ProtitlesMapper.class);
        PageHelper.startPage(pageNum, pageSize);
        List<Protitles> list = mapper.selectAll();
        PageInfo<Protitles> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    public void save(String protName,String protDescription) throws Exception{

        try {
            //驗證科室名是否可用
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            ProtitlesMapper mapper = sqlSession.getMapper(ProtitlesMapper.class);
            Protitles protitles =mapper.selectByName(protName);
            if(protitles == null){
                Protitles protitlesNew = new Protitles();
                Integer max=mapper.getMaxId();
                if(max ==null){
                    max = (Integer) 1;
                }
                protitlesNew.setProtitleId((int)max +1);
                protitlesNew.setProtitleName(protName);
                protitlesNew.setProtitleDescription(protDescription);
                mapper.insert(protitlesNew);
            }
            else
            {
                //科室名稱重複
                throw new Exception("職稱名已存在!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int protId,String protName,String protDesc) throws Exception{
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            ProtitlesMapper mapper = sqlSession.getMapper(ProtitlesMapper.class);
            Protitles protitles =mapper.selectByName(protName);
            if (protitles == null) {
                mapper.updateById(protId,protName,protDesc);
            } else {
                //科室名稱重複
                throw new Exception("職稱名稱已存在!");
            }

        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
        /*finally {
        }*/
    }


    public void deleteProtById(int deptId) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            ProtitlesMapper mapper = sqlSession.getMapper(ProtitlesMapper.class);
            mapper.deleteById(deptId);
        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
    }

}
