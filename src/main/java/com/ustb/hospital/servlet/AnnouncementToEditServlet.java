package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Announcement;
import com.ustb.hospital.service.AnnouncementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/anct/ancttoedit")
public class AnnouncementToEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String announcementId = req.getParameter("announcementId");
        AnnouncementServiceImpl service = new AnnouncementServiceImpl();
        Announcement announcement = service.queryById(Integer.parseInt(announcementId));
        List<Announcement> announcements = new ArrayList<>();
        announcements.add(announcement);
        req.setAttribute("announcements", announcements);
        req.getRequestDispatcher("/anct/anctedit.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果需要處理POST請求，在這裡進行處理
        doGet(req, resp);
    }
}

