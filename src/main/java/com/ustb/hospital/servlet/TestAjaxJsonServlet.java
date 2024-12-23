package com.ustb.hospital.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ustb.hospital.entity.Departments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ajax")
public class TestAjaxJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Departments dept =new Departments();
        dept.setDepartmentName("testJson");
        System.out.println(dept);

        ObjectMapper objectMapper =new ObjectMapper();
        String s = objectMapper.writeValueAsString(dept);
        System.out.println(s);
        ArrayList<Departments> list = new ArrayList<>();
        list.add(dept);
        String s1 = objectMapper.writeValueAsString(list);
        System.out.println(s1);
        resp.setContentType("test/html;charset=utf-8");
        resp.getWriter().write(s1);
    }

}
