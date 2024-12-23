package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Admins;
import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.service.AdminsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;
import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/admintoedit")
public class AdminsToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String adminId = req.getParameter("adminId");
        AdminsServiceImpl service = new AdminsServiceImpl();
        Admins admins = service.queryById(Integer.parseInt(adminId));
        List<Admins> admin= new ArrayList<Admins>();
        admin.add(admins);
        req.setAttribute("admin", admin);
        req.getRequestDispatcher("/admin/adminedit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果需要處理POST請求，在這裡進行處理
        doGet(req, resp);
    }

}
