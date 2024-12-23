package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/pat/pattoedit")
public class PatientsToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String patId = req.getParameter("patientId");
        PatientsServiceImpl service = new PatientsServiceImpl();
        Patients patient = service.queryById(Integer.parseInt(patId));
        List<Patients> patients =new ArrayList<Patients>();
        patients.add(patient);
        req.setAttribute("patients", patients);
        req.getRequestDispatcher("/pat/patedit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果需要處理POST請求，在這裡進行處理
        doGet(req, resp);
    }

}

