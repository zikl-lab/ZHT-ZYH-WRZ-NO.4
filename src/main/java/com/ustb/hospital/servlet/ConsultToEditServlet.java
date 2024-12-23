package com.ustb.hospital.servlet;


import com.ustb.hospital.entity.*;
import com.ustb.hospital.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/con/toEdit")
public class ConsultToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        String id = req.getParameter("consultationId");
        ConsultationServiceImpl service =new ConsultationServiceImpl();
        Consultation consultation = service.queryById(Integer.parseInt(id));
        DoctorsServiceImpl service1 =new DoctorsServiceImpl();
        PatientsServiceImpl service2 =new PatientsServiceImpl();
        List<Doctors> list1 = service1.queryAllDoc();
        List<Patients> list2 = service2.queryAllPat();
        req.setAttribute("list1", list1);
        req.setAttribute("list2", list2);
        //转发重定向
        req.setAttribute("consultation",consultation);
        req.getRequestDispatcher("/consult/edit.jsp").forward(req,resp);


    }
}
