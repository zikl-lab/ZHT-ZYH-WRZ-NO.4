package com.ustb.hospital.servlet;


import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;
import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/doc/docinftoedit")
public class DoctorsinfToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        String id = req.getParameter("doctorsId");
        DoctorsServiceImpl service =new DoctorsServiceImpl();
        Doctors doctors =service.queryById(Integer.parseInt(id));
        ProtitlesServiceImpl service1 = new ProtitlesServiceImpl();
        List<Protitles> list2 = service1.queryAllProt();
        req.setAttribute("list2", list2);
        DepartmentsServiceImpl service2 = new DepartmentsServiceImpl();
        List<Departments> list1 = service2.queryAllDept();
        req.setAttribute("list1", list1);
        //转发重定向
        req.setAttribute("doctors",doctors);
        req.getRequestDispatcher("/doc/docinfedit.jsp").forward(req,resp);


    }
}
