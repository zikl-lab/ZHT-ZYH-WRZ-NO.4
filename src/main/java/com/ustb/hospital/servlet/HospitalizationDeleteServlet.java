package com.ustb.hospital.servlet;


import com.ustb.hospital.service.HospitalizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hos/hosdelete")
public class HospitalizationDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String hosId = req.getParameter("hosId");
        HospitalizationServiceImpl service = new HospitalizationServiceImpl();
        System.out.println(hosId);
        try {
            System.out.println(hosId);
            service.deleteDeptById(Integer.parseInt(hosId));
            resp.sendRedirect("/hos/hoslist");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("11111");
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/hos/hoslist");
        }

    }



}