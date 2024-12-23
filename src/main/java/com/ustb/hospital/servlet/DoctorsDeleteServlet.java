package com.ustb.hospital.servlet;

import com.ustb.hospital.service.ConsultationServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doc/docdelete")
public class DoctorsDeleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        String deptId = req.getParameter("deptId");

        //2 调用业务
        DoctorsServiceImpl service =new DoctorsServiceImpl();

        try {
            service.delete(Integer.parseInt(deptId));
            System.out.println("2222");
            resp.sendRedirect("/doc/doclist");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            System.out.println("1111");
            resp.sendRedirect("/doc/doclist");
        }
    }
}
