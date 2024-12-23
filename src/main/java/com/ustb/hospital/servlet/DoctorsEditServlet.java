package com.ustb.hospital.servlet;


import com.ustb.hospital.service.ConsultationServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/doc/docedit")
public class DoctorsEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        String id = req.getParameter("doctorId");
        String doctorNumber = req.getParameter("doctorNumber");
        String doctorPassword = req.getParameter("doctorPassword");
        String doctorName = req.getParameter("doctorName");
        String doctorAvatar = req.getParameter("doctorAvatar");
        String doctorPhone = req.getParameter("doctorPhone");
        String doctorEmail = req.getParameter("doctorEmail");
        String doctorIntion = req.getParameter("doctorIntion");
        String doctorReFee = req.getParameter("doctorReFee");
        String doctorEnData = req.getParameter("doctorEnData");
        String doctorDeptId = req.getParameter("doctorDeptId");
        String doctorProTitleId = req.getParameter("doctorProTitleId");

        DoctorsServiceImpl service =new DoctorsServiceImpl();


        try {
            service.update(Integer.parseInt(id),doctorNumber,doctorPassword,doctorName,doctorAvatar,doctorPhone,doctorEmail,doctorIntion,doctorReFee,doctorEnData,Integer.parseInt(doctorDeptId),Integer.parseInt(doctorProTitleId));
            //修改成功
            resp.sendRedirect("/doc/doclist");
        }catch (NumberFormatException e){
            //throw new RuntimeException(e);
            e.printStackTrace();
            //修改失败
            resp.sendRedirect("/doc/doctoedit?doctorsId="+id);
        }


    }
}
