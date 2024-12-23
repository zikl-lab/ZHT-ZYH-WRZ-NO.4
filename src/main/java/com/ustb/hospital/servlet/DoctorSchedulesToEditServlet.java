package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.DoctorSchedules;
import com.ustb.hospital.service.DoctorSchedulesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/schedule/schetoedit")
public class DoctorSchedulesToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String scheduleId = req.getParameter("scheduleId");
        DoctorSchedulesServiceImpl service = new DoctorSchedulesServiceImpl();
        DoctorSchedules doctorSchedules = service.queryById(Integer.parseInt(scheduleId));
        List<DoctorSchedules> doctorSchedule = new ArrayList<DoctorSchedules>();
        doctorSchedule.add(doctorSchedules);


        req.setAttribute("doctorSchedule", doctorSchedule);
        req.getRequestDispatcher("/schedule/scheedit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果需要處理POST請求，在這裡進行處理
        doGet(req, resp);
    }

}