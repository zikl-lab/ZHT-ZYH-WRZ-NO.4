package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Admins;
import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.mapper.AdminsMapper;
import com.ustb.hospital.mapper.ProtitlesMapper;
import com.ustb.hospital.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AdminsServiceImpl {
    public Admins queryByUsername(String username){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);
        Admins admins = mapper.selectByUsername(username);
        return admins;

    }

    public String getPassword(int adminId){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);
        String password= mapper.getPassword(adminId);
        return password;
    }

    public void update(int adminId,String password) throws Exception {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);

            mapper.updateById(adminId, password);
        }catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
    }

    public Admins queryById(int adminId){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);

        Admins admins = mapper.selectById(adminId);

        return admins;
    }

    public PageInfo<Admins> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 获取 Mapper 对象
        AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);
        PageHelper.startPage(pageNum, pageSize);
        List<Admins> list = mapper.selectAll();
        PageInfo<Admins> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
