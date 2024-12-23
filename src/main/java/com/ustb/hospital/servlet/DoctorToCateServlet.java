package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Departments;
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

@WebServlet("/doc/doctocate")
public class DoctorToCateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DoctorsServiceImpl service = new DoctorsServiceImpl();
        DepartmentsServiceImpl service1 =new DepartmentsServiceImpl();
        ProtitlesServiceImpl service2 =new ProtitlesServiceImpl();
        List<Departments> list1 = service1.querySecondDept();
        List<Protitles> list2 = service2.queryAllProt();
        req.setAttribute("list1", list1);
        req.setAttribute("list2", list2);
        req.getRequestDispatcher("/doc/doccate.jsp").forward(req, resp);
    }
}
