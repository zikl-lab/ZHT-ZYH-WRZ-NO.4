package com.ustb.hospital.servlet;

import com.ustb.hospital.service.DoctorSchedulesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/schedelete")
public class DoctorSchedulesDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String scheduleId = req.getParameter("scheduleId");
        DoctorSchedulesServiceImpl service = new DoctorSchedulesServiceImpl();
        System.out.println(scheduleId);
        try {
            System.out.println(scheduleId);
            service.deleteScheduleById(Integer.parseInt(scheduleId));
            resp.sendRedirect("/schedule/schedulelist");
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/schedule/schedulelist");
        }

    }


}