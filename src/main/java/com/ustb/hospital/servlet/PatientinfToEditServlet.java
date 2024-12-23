package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;
import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pat/patinftoedit")
public class PatientinfToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        String id = req.getParameter("patientId");
        PatientsServiceImpl service =new PatientsServiceImpl();
        Patients patients =service.queryById(Integer.parseInt(id));

        //转发重定向
        req.setAttribute("patients",patients);
        req.getRequestDispatcher("/pat/patinfedit.jsp").forward(req,resp);


    }
}
