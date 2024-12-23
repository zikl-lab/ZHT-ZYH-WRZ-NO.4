package com.ustb.hospital.servlet;

import com.ustb.hospital.service.AnnouncementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/anct/anctedit")
public class AnnouncementEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String announcementId = req.getParameter("announcementId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String creationTime = req.getParameter("creationTime");
        String creator = req.getParameter("creator");
        AnnouncementServiceImpl service = new AnnouncementServiceImpl();
        try {
            service.update(Integer.parseInt(announcementId),title,content,creationTime,creator);
            resp.sendRedirect("/anct/anctlist");
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/anct/ancttoedit?announcementId="+announcementId);
        }

    }


}