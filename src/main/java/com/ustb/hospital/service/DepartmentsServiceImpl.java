package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.mapper.DepartmentsMapper;
import com.ustb.hospital.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class DepartmentsServiceImpl {

    public void save(int deptPid,String deptName,String deptDesc) throws Exception{

        try {
            //驗證科室名是否可用
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            // 获取 Mapper 对象
            DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
            Departments departments =mapper.selectByName(deptName);
            if(departments == null){
                Departments departmentsNew = new Departments();
                Integer max=mapper.getMaxId();
                if(max ==null){
                    max = (Integer) 0;
                }
                departmentsNew.setDepartmentId((int)max +1);
                departmentsNew.setDepartmentName(deptName);
                departmentsNew.setDepartmentDescription(deptDesc);
                //判斷級數
                if (deptPid == -1){
                    //當前保存的是一級科室
//                    departmentsNew.setDepartmentPid(0);
                    departmentsNew.setDepartmentLevel(1);
                    departmentsNew.setDepartmentPath("|"+departmentsNew.getDepartmentId()+"|");
                }
                else {
                    //當前保存的是二級科室
                    Departments departments1 = mapper.selectById(deptPid);
                    if(departments1 == null){
                        //父科室不存在，異常
                        throw new Exception("父科室不存在");

                    }
                    else
                    {
                        departmentsNew.setDepartmentPid(deptPid);
                        departmentsNew.setDepartmentLevel(departments1.getDepartmentLevel()+1);
                        departmentsNew.setDepartmentPath("|"+deptPid+"||"+departmentsNew.getDepartmentId() +"|");
                    }
                }
                mapper.insert(departmentsNew);
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

    public List<Departments> querySecondDept() {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);

        List<Departments> list =mapper.selectFirstDept(2);
        return list;
    }

    public List<Departments> queryFirstDept(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        List<Departments> list =mapper.selectFirstDept(1);
        return list;
    }

    public List<Departments> queryAllDept(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        List<Departments> list =mapper.selectAll();
        return list;
    }

    public List<Departments> querySecondByPid(int deptPid){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);

        // 使用 PageHelper 进行分页
        List<Departments> list = mapper.selectSecondDeptByPid(deptPid);
        return list;
    }

    public Departments queryById(int deptId){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);

        // 使用 PageHelper 进行分页
        Departments departments = mapper.selectById(deptId);
        return departments;
    }

    public PageInfo<Departments> queryAll(int pageNum, int pageSize) {
        // 调用工具类获取 SqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 获取 Mapper 对象
        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);

        // 使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<Departments> list = mapper.selectFirstDept(1);

        // 封装分页结果
        PageInfo<Departments> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
    public void update(int deptId,String deptName,String deptDesc) throws Exception{

        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
            Departments departments =mapper.selectByName(deptName);
            if (departments == null) {
                mapper.updateById(deptId,deptName,deptDesc);
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

    public int deleteDeptById(int deptId) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
            List<Departments> list =mapper.selectSecondDeptByPid(deptId);
            if (list == null) {
                mapper.deleteById(deptId);
                return 1;
            }
            else {
                mapper.deleteById(deptId);
                System.out.println("全部刪除！");
                return 0;
            }
        }
        catch (NegativeArraySizeException e) {
            throw new RuntimeException(e);
        }
    }
}