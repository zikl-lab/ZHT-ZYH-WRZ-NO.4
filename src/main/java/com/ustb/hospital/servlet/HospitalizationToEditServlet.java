package com.ustb.hospital.servlet;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Hospitalization;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.DoctorsServiceImpl;
import com.ustb.hospital.service.HospitalizationServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/hos/hostoedit")
public class HospitalizationToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String hosId = req.getParameter("hosId");
        HospitalizationServiceImpl service = new HospitalizationServiceImpl();
        Hospitalization hospitalization = service.queryById(Integer.parseInt(hosId));
        List<Hospitalization> hospitalizations = new ArrayList<Hospitalization>();
        hospitalizations.add(hospitalization);
        PatientsServiceImpl service1 =new PatientsServiceImpl();
        List<Patients> list1 = service1.queryAllPat();
        req.setAttribute("list1", list1);

        req.setAttribute("hospitalization", hospitalizations);
        req.getRequestDispatcher("/hos/hosedit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果需要處理POST請求，在這裡進行處理
        doGet(req, resp);
    }

}

