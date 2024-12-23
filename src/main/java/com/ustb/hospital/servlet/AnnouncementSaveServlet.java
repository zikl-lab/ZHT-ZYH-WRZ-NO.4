package com.ustb.hospital.servlet;


import com.ustb.hospital.service.AnnouncementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/anct/save")
public class AnnouncementSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 處理亂碼
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 接收請求參數
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String creationTime = req.getParameter("creationTime");
        String creator = req.getParameter("creator");

        // 調用業務
        AnnouncementServiceImpl service = new AnnouncementServiceImpl();
        try {
            service.save(title, content,creationTime,creator);
            resp.sendRedirect("/anct/anctlist");
        } catch (NumberFormatException e) {
            // 處理數字格式錯誤的情況
            e.printStackTrace();
            resp.sendRedirect("/anct/ancttoedit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

