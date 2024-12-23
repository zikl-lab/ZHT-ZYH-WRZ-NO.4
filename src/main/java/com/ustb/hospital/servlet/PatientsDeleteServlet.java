package com.ustb.hospital.servlet;
import com.ustb.hospital.service.PatientsServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pat/patdelete")
public class PatientsDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String patId = req.getParameter("patId");
        PatientsServiceImpl service = new PatientsServiceImpl();
        System.out.println(patId);
        try {
            System.out.println(patId);
            service.deleteDeptById(Integer.parseInt(patId));
            resp.sendRedirect("/pat/patlist");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("11111");
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/pat/patlist");
        }

    }



}