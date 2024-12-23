package com.ustb.hospital.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dept/second")
public class DepartmentsSecondListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //1.接收請求參數
        String deptPid = req.getParameter("deptPid");
        DepartmentsServiceImpl service=new DepartmentsServiceImpl();
        List<Departments> list = service.querySecondByPid(Integer.parseInt(deptPid));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(list);
        resp.getWriter().write(jsonStr);




    }

}
