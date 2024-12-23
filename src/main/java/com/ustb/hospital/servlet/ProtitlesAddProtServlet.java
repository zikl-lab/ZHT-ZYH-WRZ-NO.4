package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.service.DoctorsServiceImpl;
import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/prot/protadd")
public class ProtitlesAddProtServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        ProtitlesServiceImpl service = new ProtitlesServiceImpl();
        List<Protitles> list = service.queryAllProt();
        req.setAttribute("list", list);
        //获取第1页，10条内容，默认查询总数count
        if (AdminsLoginServlet.a != "1") {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/prot/protadd.jsp").forward(req, resp);
        }
    }
}
