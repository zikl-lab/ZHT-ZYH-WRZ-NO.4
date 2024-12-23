package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Protitles;
import com.ustb.hospital.service.PatientsServiceImpl;
import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/prot/prottoedit")
public class ProtitlesToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String protId = req.getParameter("protId");
        ProtitlesServiceImpl service = new ProtitlesServiceImpl();
        Protitles protitles = service.queryById(Integer.parseInt(protId));
        List<Protitles> protitle= new ArrayList<Protitles>();
        protitle.add(protitles);
        req.setAttribute("protitle", protitle);
        req.getRequestDispatcher("/prot/protedit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果需要處理POST請求，在這裡進行處理
        doGet(req, resp);
    }

}
