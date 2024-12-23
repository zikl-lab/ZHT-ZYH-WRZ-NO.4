package com.ustb.hospital.servlet;

import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.*;
import com.ustb.hospital.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/con/confirst")
public class ConsultFirstListServlet extends HttpServlet{
    //qu 添加界面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ConsultationServiceImpl service = new ConsultationServiceImpl();
        List<Consultation> list = service.queryFirstAll();
        DoctorsServiceImpl service1 =new DoctorsServiceImpl();
        PatientsServiceImpl service2 =new PatientsServiceImpl();
        List<Doctors> list1 = service1.queryAllDoc();
        List<Patients> list2 = service2.queryAllPat();
        req.setAttribute("list1", list1);
        req.setAttribute("list2", list2);
        req.setAttribute("list",list);
        req.getRequestDispatcher("/consult/add.jsp").forward(req,resp);

    }
}
