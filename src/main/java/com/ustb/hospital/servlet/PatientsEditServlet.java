package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pat/patedit")
public class PatientsEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String patientId = req.getParameter("patientId");
        String patientIdCard = req.getParameter("patientIdCard");
        String patientPassword = req.getParameter("patientPassword");
        String patientName = req.getParameter("patientName");
        String patientAvatar = req.getParameter("patientAvatar");
        String patientPhone = req.getParameter("patientPhone");
        String patientEmail = req.getParameter("patientEmail");
        String patientBalance = req.getParameter("patientBalance");
        PatientsServiceImpl service = new PatientsServiceImpl();
        try {
            service.update(Integer.parseInt(patientId),patientIdCard,patientPassword,patientName,patientAvatar,patientPhone,patientEmail,Double.parseDouble(patientBalance));
            resp.sendRedirect("/pat/patlist");
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/pat/pattoedit?patientIdCard="+patientIdCard);
        }

    }


}