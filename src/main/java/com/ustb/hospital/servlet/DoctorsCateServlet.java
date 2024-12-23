package com.ustb.hospital.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

///doc/doctorlist?pageNum=1
@WebServlet("/doc/doccate")
public class DoctorsCateServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DoctorsServiceImpl service = new DoctorsServiceImpl();
        int i = 1;
        String pageNum = req.getParameter("pageNum");
        System.out.println(pageNum);
        if (pageNum != null && !pageNum.equals("")) {
            i = Integer.parseInt(pageNum);
        }

        String docNumber = req.getParameter("docNumber");
        String docName = req.getParameter("docName");
        String deptId = req.getParameter("deptId");
        PageInfo pageInfo = service.queryByPage(i, 5,docNumber,docName,Integer.parseInt(deptId));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(pageInfo);
        resp.getWriter().write(jsonStr);
    }
}
