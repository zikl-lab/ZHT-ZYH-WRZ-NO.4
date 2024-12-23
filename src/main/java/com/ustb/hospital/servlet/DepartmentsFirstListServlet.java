package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;

@WebServlet("/dept/first")
public class DepartmentsFirstListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DepartmentsServiceImpl service = new DepartmentsServiceImpl();
        List<Departments> list=service.queryFirstDept();
        req.setAttribute("list",list);

        if(AdminsLoginServlet.a != "1" ) {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        else
        {
            req.getRequestDispatcher("/dept/deptadd.jsp").forward(req, resp);
        }
    }
}
