package com.ustb.hospital.servlet;



import com.ustb.hospital.service.AppointmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/appoint/appointedit")
public class AppointmentEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String appointId = req.getParameter("appointId");
        String appointPId= req.getParameter("appointPId");
        String appointDId = req.getParameter("appointDId");
        String appointDate = req.getParameter("appointDate");
        String appointTime = req.getParameter("appointTime");
        String appointStatus = req.getParameter("appointStatus");
        System.out.println(appointId+appointPId+appointDId+appointDate+appointTime+appointStatus);
        AppointmentServiceImpl service = new AppointmentServiceImpl();
        try {
            service.update(Integer.parseInt(appointId),Integer.parseInt(appointPId),Integer.parseInt(appointDId),appointDate,appointTime,appointStatus);
            resp.sendRedirect("/appoint/appointlist");
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/appoint/appointtoedit?appointId="+appointId);
        }

    }


}