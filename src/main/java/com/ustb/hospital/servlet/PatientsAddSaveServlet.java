package com.ustb.hospital.servlet;

import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;
import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pat/patsave")
public class PatientsAddSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //處理亂碼
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //1.接收請求參數
        String patientIdCard = req.getParameter("patientIdCard");
        String patientPassword = req.getParameter("patientPassword");
        String patientName = req.getParameter("patientName");
        String patientAvatar = req.getParameter("patientAvatar");
        String patientPhone = req.getParameter("patientPhone");
        String patientEmail = req.getParameter("patientEmail");
        String patientBalance = req.getParameter("patientBalance");
        //2.調用業務
        PatientsServiceImpl service = new PatientsServiceImpl();
        try {
            service.save(patientIdCard,patientPassword,patientName, patientAvatar,patientPhone,patientEmail,Double.parseDouble(patientBalance));
            //3.頁面導航
            //沒有異常
            resp.sendRedirect("/pat/patlist");

        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            //保存失敗
            resp.sendRedirect("/pat/patadd");


        } /*finally {
        }*/

    }

}
