package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.DoctorSchedules;
import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.DoctorSchedulesServiceImpl;
import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/schedule/scheadd")
public class DoctorScheduleAddServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DoctorSchedulesServiceImpl service = new DoctorSchedulesServiceImpl();
        List<DoctorSchedules> list=service.queryAllSchedules();
        req.setAttribute("list", list);
        DepartmentsServiceImpl service1 =new DepartmentsServiceImpl();
        List<Departments> list1 = service1.querySecondDept();
        req.setAttribute("list1", list1);

        req.getRequestDispatcher("/schedule/scheadd.jsp").forward(req, resp);

    }
}