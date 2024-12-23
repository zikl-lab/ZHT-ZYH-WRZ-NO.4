package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.AppointmentServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/appoint/appapp")
public class AppointmentAppServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收請求參數
        String doctorId= req.getParameter("doctorId");
        String appointDate = req.getParameter("appointDate");
        String appointTime = req.getParameter("appointTime");
        String status = "booked";
        PatientsServiceImpl service1 = new PatientsServiceImpl();
        Patients patient = service1.queryByName(AdminsLoginServlet.loginName);
        int appointPId = patient.getPatientId();
        // 調用業務
        AppointmentServiceImpl service = new AppointmentServiceImpl();
        try {
            System.out.println(appointPId+"0"+doctorId+"0"+appointDate+appointTime+status);
            service.save(appointPId,Integer.parseInt(doctorId),appointDate,appointTime,status);
            resp.sendRedirect("/appoint/appointlist");
        } catch (NumberFormatException e) {
            // 處理數字格式錯誤的情況
            e.printStackTrace();
            resp.sendRedirect("/appoint/appointtoedit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
