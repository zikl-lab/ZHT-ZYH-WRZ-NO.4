package com.ustb.hospital.servlet;


import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.DoctorsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/pat/Ppatlist")
public class PPatientsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果需要處理POST請求，在這裡進行處理
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id =req.getParameter("patientId");
        int i = 1;
        String pageNum = req.getParameter("pageNum");
        System.out.println(pageNum);
        if (pageNum != null && !pageNum.equals("")) {
            i = Integer.parseInt(pageNum);
        }
        PatientsServiceImpl service = new PatientsServiceImpl();
        PageInfo pageInfos = service.queryonePat(AdminsLoginServlet.loginName,i,5);
        req.setAttribute("pageInfos", pageInfos);
        //获取第1页，10条内容，默认查询总数count
        if (AdminsLoginServlet.a != "1") {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pat/Ppatlist.jsp").forward(req, resp);
        }
    }

}
