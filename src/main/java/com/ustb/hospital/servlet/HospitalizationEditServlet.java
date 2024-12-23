package com.ustb.hospital.servlet;



import com.ustb.hospital.service.HospitalizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hos/hosedit")
public class HospitalizationEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String hosId = req.getParameter("hosId");
        String hosPId= req.getParameter("hosPId");
        String hosRoom = req.getParameter("hosRoom");
        String hosCost = req.getParameter("hosCost");
        String hosPStatus = req.getParameter("hosPStatus");
        String hosInsured = req.getParameter("hosInsured");
        String hosStatus = req.getParameter("hosStatus");
        HospitalizationServiceImpl service = new HospitalizationServiceImpl();
        try {
            service.update(Integer.parseInt(hosId),Integer.parseInt(hosPId),hosRoom,Integer.parseInt(hosCost),hosPStatus,hosInsured,hosStatus);
            resp.sendRedirect("/hos/hoslist");
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/hos/hostoedit?hosId="+hosId);
        }

    }


}