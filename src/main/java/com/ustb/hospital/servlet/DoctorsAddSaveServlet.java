package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/doc/save")
public class DoctorsAddSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");


        String doctorNumber = req.getParameter("doctorId");
        String doctorPassword = req.getParameter("doctorPassword");
        String doctorName = req.getParameter("doctorName");
        String doctorAvatar = req.getParameter("doctorAvatar");
        String doctorPhone = req.getParameter("doctorPhone");
        String doctorEmail = req.getParameter("doctorEmail");
        String doctorIntion = req.getParameter("doctorIntro");
        String doctorReFee = req.getParameter("registrationFee");
        String doctorEnData = req.getParameter("joinDate");
        String doctorDeptId = req.getParameter("doctordeptid");
        String doctorProTitleId = req.getParameter("deptPid");

        DoctorsServiceImpl service =new DoctorsServiceImpl();


        try {
            service.save(doctorNumber,doctorPassword,doctorName,doctorAvatar,doctorPhone,doctorEmail,doctorIntion,doctorReFee,doctorEnData,Integer.parseInt(doctorDeptId),Integer.parseInt(doctorProTitleId));
            //修改成功
            resp.sendRedirect("/doc/doclist");
        }catch (Exception e){
            //throw new RuntimeException(e);
            e.printStackTrace();
            //修改失败
            resp.sendRedirect("/doc/docadd");
        }finally {

        }


    }
}

