package com.ustb.hospital.servlet;


import com.ustb.hospital.entity.Appointment;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.AppointmentServiceImpl;
import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/appoint/first")
public class AppointmentFirstListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        AppointmentServiceImpl service = new AppointmentServiceImpl();
        List<Appointment> list=service.queryAllDept();
        DoctorsServiceImpl service1 =new DoctorsServiceImpl();
        PatientsServiceImpl service2 =new PatientsServiceImpl();
        List<Doctors> list1 = service1.queryAllDoc();
        List<Patients> list2 = service2.queryAllPat();
        req.setAttribute("list1", list1);
        req.setAttribute("list2", list2);
        req.setAttribute("list", list);

        req.getRequestDispatcher("/appoint/appointadd.jsp").forward(req, resp);

        }
    }

