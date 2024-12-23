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
import java.util.List;

@WebServlet("/pat/first")
public class PatientsFirstListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PatientsServiceImpl service = new PatientsServiceImpl();
        List<Patients> list=service.queryFirstDept();
        req.setAttribute("list",list);

        if(AdminsLoginServlet.a != "1" ) {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        else
        {
            req.getRequestDispatcher("/pat/patadd.jsp").forward(req, resp);
        }
    }
}
