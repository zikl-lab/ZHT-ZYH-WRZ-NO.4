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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/appoint/appointtoedit")
public class AppointmentToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String appointId = req.getParameter("appointId");
        AppointmentServiceImpl service = new AppointmentServiceImpl();
        Appointment appointment = service.queryById(Integer.parseInt(appointId));
        List<Appointment> appointments = new ArrayList<Appointment>();
        appointments.add(appointment);
        DoctorsServiceImpl service1 =new DoctorsServiceImpl();
        PatientsServiceImpl service2 =new PatientsServiceImpl();
        List<Doctors> list1 = service1.queryAllDoc();
        List<Patients> list2 = service2.queryAllPat();
        req.setAttribute("list1", list1);
        req.setAttribute("list2", list2);
        req.setAttribute("appointment", appointments);
        req.getRequestDispatcher("/appoint/appointedit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果需要處理POST請求，在這裡進行處理
        doGet(req, resp);
    }

}

