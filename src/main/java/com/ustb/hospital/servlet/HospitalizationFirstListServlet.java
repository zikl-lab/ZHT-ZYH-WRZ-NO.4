package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Hospitalization;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.HospitalizationServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hos/first")
public class HospitalizationFirstListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HospitalizationServiceImpl service = new HospitalizationServiceImpl();
        List<Hospitalization> list=service.queryAllDept();
        PatientsServiceImpl service1 =new PatientsServiceImpl();
        List<Patients> list1 = service1.queryAllPat();
        req.setAttribute("list1", list1);

        req.setAttribute("list", list);

        req.getRequestDispatcher("/hos/hosadd.jsp").forward(req, resp);

        }
    }

