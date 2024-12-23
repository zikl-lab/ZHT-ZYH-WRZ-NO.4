package com.ustb.hospital.servlet;


import com.ustb.hospital.service.ConsultationServiceImpl;
import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/con/edit")
public class ConsultEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        String id = req.getParameter("consultationId");
        String patientId = req.getParameter("patientId");
        String doctorId = req.getParameter("doctorId");
        String consultationTime = req.getParameter("consultationTime");
        String isHospitalRegistered = req.getParameter("isHospitalRegistered");
        String isHospitalized = req.getParameter("isHospitalized");
        String medicalAdviceCase = req.getParameter("medicalAdviceCase");

        ConsultationServiceImpl service =new ConsultationServiceImpl();
        try {
            service.update(Integer.parseInt(id),Integer.parseInt(patientId),Integer.parseInt(doctorId),consultationTime,Integer.parseInt(isHospitalRegistered),Integer.parseInt(isHospitalized),medicalAdviceCase);
            //修改成功
            resp.sendRedirect("/con/conlist");
        }catch (NumberFormatException e){
            //throw new RuntimeException(e);
            e.printStackTrace();
            //修改失败
            resp.sendRedirect("/con/toEdit?deptId="+id);
        }


    }
}
