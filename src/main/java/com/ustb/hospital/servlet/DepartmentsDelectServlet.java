package com.ustb.hospital.servlet;

import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/dept/deptdelete")
public class DepartmentsDelectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String deptId = req.getParameter("deptId");
        DepartmentsServiceImpl service = new DepartmentsServiceImpl();
        System.out.println(deptId);
        try {
            System.out.println(deptId);
            int now = service.deleteDeptById(Integer.parseInt(deptId));
            if (now ==1) {
                resp.sendRedirect("/dept/deptlist");
            }
            else{
                resp.sendRedirect("/dept/deptlist");//暫不做處理
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("11111");
            /*throw new RuntimeException(e);*/
            resp.sendRedirect("/dept/deptlist");
        }

    }


}