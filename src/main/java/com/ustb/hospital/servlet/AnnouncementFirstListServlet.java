package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Announcement;
import com.ustb.hospital.service.AnnouncementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/anct/first")
public class AnnouncementFirstListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        AnnouncementServiceImpl service = new AnnouncementServiceImpl();
        List<Announcement> list=service.queryAllanct();
        req.setAttribute("list", list);

        req.getRequestDispatcher("/anct/anctadd.jsp").forward(req, resp);

        }
    }

