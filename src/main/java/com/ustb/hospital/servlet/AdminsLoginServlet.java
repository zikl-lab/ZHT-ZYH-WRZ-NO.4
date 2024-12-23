package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Admins;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.AdminsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class AdminsLoginServlet extends HttpServlet {
    public static String a = "0";
    public static String loginName;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(a);
        req.setAttribute("a", a);
        a = "0";
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String loginvalue = req.getParameter("loginvalue");
        String code = req.getParameter("code");
//2.调用Service0

//3.页面导航
        if (loginvalue.equals("0")) {
            PatientsServiceImpl patientsService = new PatientsServiceImpl();
            Patients patients = patientsService.queryByPhone(username);
            if (code == null || !code.equals("6982")) {
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
            else {
                if (!patients.getPatientPassword().equals(password)) {
                    System.out.println("密码错误");
//3.2 登录失败：回到登录页面
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
                else {
                    System.out.println("患者登录成功");
                    loginName = patients.getPatientName();
                    req.setAttribute("loginName", loginName);
                    a = "1";
                    // 在你的Servlet中
                    System.out.println(a);
                    req.setAttribute("a", a);
                    req.getRequestDispatcher("/patient.jsp").forward(req, resp);
                }
            }

        }
        else if (loginvalue.equals("1")){
            DoctorsServiceImpl doctorsServiceImpl = new DoctorsServiceImpl();
            Doctors doctors = doctorsServiceImpl.queryByNumber(username);
            if (code == null || !code.equals("6982")) {
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
            else {
                if (!doctors.getDoctorPassword().equals(password)) {
                    System.out.println("密码错误");
//3.2 登录失败：回到登录页面
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
                else {
                    System.out.println("医生登录成功");
                    loginName = doctors.getDoctorName();
                    req.setAttribute("loginName", loginName);
                    a = "1";
                    // 在你的Servlet中
                    System.out.println(a);
                    req.setAttribute("a", a);
                    req.getRequestDispatcher("/doctor.jsp").forward(req, resp);
                }
            }

        }
        else {
            AdminsServiceImpl adminsService = new AdminsServiceImpl();
            Admins admins = adminsService.queryByUsername(username);
            if (code == null || !code.equals("6982")) {
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
            else {
                if (!admins.getPassword().equals(password)) {
                    System.out.println("密码错误");
//3.2 登录失败：回到登录页面
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
                else {
                    System.out.println("管理员登录成功");
                    loginName = admins.getName();
                    req.setAttribute("loginName", loginName);
                    a= "1";
                    // 在你的Servlet中
                    req.setAttribute("a", a);
                    req.getRequestDispatcher("/admin.jsp").forward(req, resp);
                }
            }
        }
    }
}
