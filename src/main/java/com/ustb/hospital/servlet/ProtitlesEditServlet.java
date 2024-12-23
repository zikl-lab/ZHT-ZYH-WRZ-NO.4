package com.ustb.hospital.servlet;

import com.ustb.hospital.service.PatientsServiceImpl;
import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/prot/protedit")
public class ProtitlesEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String protId = req.getParameter("protId");
        String protName = req.getParameter("protName");
        String protDesc = req.getParameter("protDesc");
        ProtitlesServiceImpl service = new ProtitlesServiceImpl();
        try {
            service.update(Integer.parseInt(protId),protName,protDesc);
            resp.sendRedirect("/prot/protlist");
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/prot/prottoedit?protId="+protId);
        }

    }


}
