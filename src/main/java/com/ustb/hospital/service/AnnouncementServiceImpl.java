package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Announcement;
import com.ustb.hospital.mapper.AnnouncementMapper;
import com.ustb.hospital.utils.MybatisUtil;

import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class AnnouncementServiceImpl {

    public void save(String content,String title,String creationTime,String creator) throws Exception{

        try {
            //驗證科室名是否可用
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            AnnouncementMapper mapper = sqlSession.getMapper(AnnouncementMapper.class);
            Announcement announcement =mapper.selectByTitle(title);
            if(announcement == null){
                Announcement announcementNew = new Announcement();
                Integer max=mapper.getMaxId();
                if(max ==null){
                    max = (Integer) 0;
                }
                announcementNew.setAnnouncementId(max+1);
                announcementNew.setTitle(title);
                announcementNew.setContent(content);
                announcementNew.setCreationTime(creationTime);
                announcementNew.setCreator(creator);
                //判斷級數
                mapper.insert(announcementNew);
            }
            else
            {
                //科室名稱重複
                throw new Exception("科室名稱已存在!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*finally {
        }*/

    }

    public List<Announcement> queryAllanct(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        AnnouncementMapper mapper = sqlSession.getMapper(AnnouncementMapper.class);
        List<Announcement> list =mapper.selectAll();
        return list;
    }

//    public List<Announcements> querySecondByPid(int anctPid){
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//
//        // 获取 Mapper 对象
//        AnnouncementMapper mapper = sqlSession.getMapper(AnnouncementMapper.class);
//
//        // 使用 PageHelper 进行分页
//        List<DAnnouncement> list = mapper.selectSecondanctByPid(anctPid);
//        return list;
//    }

    public Announcement queryById(int announcementId){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        AnnouncementMapper mapper = sqlSession.getMapper(AnnouncementMapper.class);

        // 使用 PageHelper 进行分页
        Announcement announcement = mapper.selectById(announcementId);
        return announcement;
    }

    public PageInfo<Announcement> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        AnnouncementMapper mapper = sqlSession.getMapper(AnnouncementMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<Announcement> list = mapper.selectAll();

        // 封装分页结果
        PageInfo<Announcement> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    public void update(int announcementId,String content,String tltle,String creationTime,String creator) throws Exception{

        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AnnouncementMapper mapper = sqlSession.getMapper(AnnouncementMapper.class);
            Announcement announcement =mapper.selectByTitle(tltle);
            if (announcement == null) {
                mapper.updateById(announcementId,tltle,content,creationTime,creator);
            } else {
                //科室名稱重複
                throw new Exception("科室名稱已存在!");
            }

        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
        /*finally {
        }*/
    }
    public void deleteanctById(int announcementId) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AnnouncementMapper mapper = sqlSession.getMapper(AnnouncementMapper.class);
                mapper.deleteById(announcementId);

        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
    }
}