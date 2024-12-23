package com.ustb.hospital.servlet;

import com.ustb.hospital.service.DoctorSchedulesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/scheedit")
public class DoctorSchedulesEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String scheduleId = req.getParameter("scheduleId");
        String doctorId = req.getParameter("doctorId");
        String date = req.getParameter("date");
        String shiftTime = req.getParameter("shiftTime");
        String departmentId=req.getParameter("departmentId");
        String isAvailable=req.getParameter("isAvailable");
        String visitCount=req.getParameter("visitCount");
        String remarks=req.getParameter("remarks");
        DoctorSchedulesServiceImpl service = new DoctorSchedulesServiceImpl();
        try {
            service.update(Integer.parseInt(scheduleId),
                    Integer.parseInt(doctorId),
                    date,
                    shiftTime,
                    Integer.parseInt(departmentId),
                    Integer.parseInt(isAvailable),
                    Integer.parseInt(visitCount),
                    remarks);
            resp.sendRedirect("/schedule/schedulelist");
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/schedule/schetoedit?scheduleId="+scheduleId);
        }

    }


}