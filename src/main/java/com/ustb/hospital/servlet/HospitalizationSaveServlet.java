package com.ustb.hospital.servlet;

import com.ustb.hospital.service.HospitalizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hos/save")
public class HospitalizationSaveServlet extends HttpServlet {
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
        String hosPId= req.getParameter("hosPId");
        String hosRoom = req.getParameter("hosRoom");
        String hosCost = req.getParameter("hosCost");
        String hosPStatus = req.getParameter("hosPStatus");
        String hosInsured = req.getParameter("hosInsured");
        String hosStatus = req.getParameter("hosStatus");
        // 調用業務
        HospitalizationServiceImpl service = new HospitalizationServiceImpl();
        try {

            service.save(Integer.parseInt(hosPId),hosRoom,Integer.parseInt(hosCost),hosPStatus,hosInsured,hosStatus);
            resp.sendRedirect("/hos/hoslist");
        } catch (NumberFormatException e) {
            // 處理數字格式錯誤的情況
            e.printStackTrace();
            resp.sendRedirect("/hos/hostoedit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

