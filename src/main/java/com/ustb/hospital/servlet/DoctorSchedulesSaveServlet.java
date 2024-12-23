package com.ustb.hospital.servlet;

import javax.servlet.http.HttpServlet;
import com.ustb.hospital.service.DoctorSchedulesServiceImpl;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/save")
public class DoctorSchedulesSaveServlet extends HttpServlet {
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
        String doctorId = req.getParameter("doctorId");
        String date = req.getParameter("date");
        String shiftTime = req.getParameter("shiftTime");
        String departmentId =req.getParameter("departmentId");
        String isAvailable = req.getParameter("isAvailable");
        String visitCount = req.getParameter("visitCount");
        String remarks = req.getParameter("remarks");



        // 調用業務
        DoctorSchedulesServiceImpl service = new DoctorSchedulesServiceImpl();
        try {

            service.save(Integer.parseInt(doctorId), date, shiftTime,Integer.parseInt(isAvailable),Integer.parseInt(departmentId),Integer.parseInt(visitCount),remarks);
            resp.sendRedirect("/schedule/schedulelist");
        } catch (NumberFormatException e) {
            // 處理數字格式錯誤的情況
            e.printStackTrace();
            resp.sendRedirect("/schedule/scheadd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
