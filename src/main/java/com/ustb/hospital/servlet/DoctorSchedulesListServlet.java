package com.ustb.hospital.servlet;

import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.DoctorSchedules;
import com.ustb.hospital.service.DoctorSchedulesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/schedule/schedulelist")
public class DoctorSchedulesListServlet extends HttpServlet {

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
        DoctorSchedulesServiceImpl service = new DoctorSchedulesServiceImpl();
        PageInfo pageInfo = service.queryAll( i , 5 );
        req.setAttribute("pageInfo",pageInfo);
        //获取第1页，10条内容，默认查询总数count
        req.getRequestDispatcher("/schedule/schedulelist.jsp").forward(req, resp);
    }
}
