package com.ustb.hospital.servlet;

import com.github.pagehelper.PageInfo;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/apppat")
public class AppointmentPatientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int i = 1;
        String pageNum = req.getParameter("pageNum");
        System.out.println(pageNum);
        if (pageNum != null && !pageNum.equals("")) {
            i = Integer.parseInt(pageNum);
        }
        DoctorsServiceImpl service = new DoctorsServiceImpl();
        PageInfo pageInfo = service.queryAll(i,5);
        req.setAttribute("pageInfo", pageInfo);
        //获取第1页，10条内容，默认查询总数count
        req.getRequestDispatcher("/appoint/apppatlist.jsp").forward(req, resp);

    }


}
