package com.ustb.hospital.servlet;

import com.github.pagehelper.PageInfo;
import com.ustb.hospital.service.ConsultationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pat/conlist")
public class ConsultpatListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int i = 1;
        String pageNum = req.getParameter("pageNum");
        System.out.println(pageNum);
        if(pageNum != null && !pageNum.equals("")) {
            i = Integer.parseInt(pageNum);
        }
        ConsultationServiceImpl service = new ConsultationServiceImpl();
        String id =req.getParameter("patientId");
        PageInfo pageInfo = service.queryByPatientId(Integer.parseInt(id), i, 5 );

/*        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(pageInfo);
        resp.getWriter().write(jsonStr);*/


        req.setAttribute("pageInfo",pageInfo);
        //获取第1页，10条内容，默认查询总数count

        req.getRequestDispatcher("/pat/consultlist.jsp").forward(req, resp);

    }
}
