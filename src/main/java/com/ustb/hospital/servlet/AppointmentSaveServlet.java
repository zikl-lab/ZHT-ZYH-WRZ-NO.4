package com.ustb.hospital.servlet;



import com.ustb.hospital.service.AppointmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/appoint/save")
public class AppointmentSaveServlet extends HttpServlet {
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
        String appointPId= req.getParameter("appointPId");
        String appointDId = req.getParameter("appointDId");
        String appointDate = req.getParameter("appointDate");
        String appointTime = req.getParameter("appointTime");
        String status = "booked";
        // 調用業務
        AppointmentServiceImpl service = new AppointmentServiceImpl();
        try {

            service.save(Integer.parseInt(appointPId),Integer.parseInt(appointDId),appointDate,appointTime,status);
            resp.sendRedirect("/appoint/appointlist");
        } catch (NumberFormatException e) {
            // 處理數字格式錯誤的情況
            e.printStackTrace();
            resp.sendRedirect("/appoint/appointtoedit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

