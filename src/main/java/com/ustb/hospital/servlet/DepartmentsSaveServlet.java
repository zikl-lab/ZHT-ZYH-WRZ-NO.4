package com.ustb.hospital.servlet;

import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dept/save")
public class DepartmentsSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 處理亂碼
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收請求參數
        String deptPid = req.getParameter("deptPid");
        String departmentName = req.getParameter("departmentName");
        String departmentDescription = req.getParameter("departmentDescription");

        // 調用業務
        DepartmentsServiceImpl service = new DepartmentsServiceImpl();
        try {
            if (deptPid != null && !deptPid.isEmpty()) {
                service.save(Integer.parseInt(deptPid), departmentName, departmentDescription);
                // 頁面導航 - 沒有異常
                resp.sendRedirect("/dept/deptlist");
            } else {
                // 處理空的 deptId 情況
                resp.sendRedirect("/dept/depttoedit");
            }
        } catch (NumberFormatException e) {
            // 處理數字格式錯誤的情況
            e.printStackTrace();
            resp.sendRedirect("/dept/depttoedit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

