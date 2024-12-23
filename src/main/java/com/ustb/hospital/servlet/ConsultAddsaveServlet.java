package com.ustb.hospital.servlet;

import com.ustb.hospital.service.ConsultationServiceImpl;
import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/con/consave")
public class ConsultAddsaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        //1.接收请求参数
        String patientId = req.getParameter("patientId");
        String doctorId = req.getParameter("doctorId");
        String consultationTime = req.getParameter("consultationTime");
        String isHospitalRegistered = req.getParameter("isHospitalRegistered");
        String isHospitalized = req.getParameter("isHospitalized");
        String medicalAdviceCase = req.getParameter("medicalAdviceCase");
        //2.调用业务
        ConsultationServiceImpl service = new ConsultationServiceImpl();
        System.out.println(patientId+doctorId+consultationTime+isHospitalRegistered+isHospitalized+medicalAdviceCase);

        try {
            service.save(Integer.parseInt(patientId),Integer.parseInt(doctorId),consultationTime,Integer.parseInt(isHospitalRegistered),Integer.parseInt(isHospitalized),medicalAdviceCase);
            //3.页面导航
            //没有异常，保存成功
            resp.sendRedirect("/con/conlist");

        } catch (Exception e) {
            e.printStackTrace();
            //throw  new RuntimeException(e);
            //保存失败,重定向
            resp.sendRedirect("/con/confirst");
        }
    }
}
