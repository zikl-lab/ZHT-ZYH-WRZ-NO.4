package com.ustb.hospital.servlet;

import com.ustb.hospital.service.AppointmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/appoint/appointdelete")
public class AppointmentDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String appointId = req.getParameter("appointId");
        AppointmentServiceImpl service = new AppointmentServiceImpl();
        System.out.println(appointId);
        try {
            System.out.println(appointId);
            service.deleteDeptById(Integer.parseInt(appointId));
            resp.sendRedirect("/appoint/appointlist");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("11111");
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/appoint/appointlist");
        }

    }



}