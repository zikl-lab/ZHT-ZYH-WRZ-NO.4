package com.ustb.hospital.servlet;

import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/apptoapp")
public class AppointmenToappServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int i = 1;
        String pageNum = req.getParameter("pageNum");
        String doctorId = req.getParameter("doctorId");
        System.out.println(pageNum);
        if(pageNum != null && !pageNum.equals("")) {
            i = Integer.parseInt(pageNum);
        }
        AppointmentServiceImpl service = new AppointmentServiceImpl();

        PageInfo pageInfos = service.queryBeforeByDid(Integer.parseInt(doctorId) , i , 5 );

        req.setAttribute("pageInfos",pageInfos);
        PatientsServiceImpl service2 = new PatientsServiceImpl();
        Patients patient = service2.queryByName(AdminsLoginServlet.loginName);
        DoctorsServiceImpl service1 =new DoctorsServiceImpl();

        Doctors doctors = service1.queryById(Integer.parseInt(doctorId));

        req.setAttribute("patient", patient);
        req.setAttribute("doctors", doctors);
        //获取第1页，10条内容，默认查询总数count
        req.getRequestDispatcher("/appoint/apptolist.jsp").forward(req, resp);

    }


}
