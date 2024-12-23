package com.ustb.hospital.servlet;

import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dept/deptedit")
public class DepartmentsEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String deptId = req.getParameter("deptId");
        String deptName = req.getParameter("deptName");
        String deptDesc = req.getParameter("deptDesc");
        DepartmentsServiceImpl service = new DepartmentsServiceImpl();
        try {
            service.update(Integer.parseInt(deptId),deptName,deptDesc);
            resp.sendRedirect("/dept/deptlist");
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/dept/depttoedit?deptId="+deptId);
        }

    }


}