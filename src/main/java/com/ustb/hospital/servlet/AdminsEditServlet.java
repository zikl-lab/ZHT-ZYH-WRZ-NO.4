package com.ustb.hospital.servlet;

import com.ustb.hospital.service.AdminsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;
import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/admin/adminedit")
public class AdminsEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String adminId = req.getParameter("adminId");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String password3 =req.getParameter("password3");

        AdminsServiceImpl service = new AdminsServiceImpl();
        String password =service.getPassword(Integer.parseInt(adminId));
        try {
            if(Objects.equals(password1, password)){
                if(Objects.equals(password2,password3)){
            service.update(Integer.parseInt(adminId),password2);
            resp.sendRedirect("/admin/adminlist");
                }else{resp.sendRedirect("/admin/admintoedit?adminId="+adminId);}
            }else{resp.sendRedirect("/admin/admintoedit?adminId="+adminId);}
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/admin/admintoedit?adminId="+adminId);
        }

    }


}