package com.ustb.hospital.servlet;

import com.ustb.hospital.service.ProtitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/prot/save")
public class ProtitlesAddSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //1.接收請求參數
        String protitleName = req.getParameter("protitleName");
        String protitleDescription = req.getParameter("protitleDescription");

        //2.調用業務
        ProtitlesServiceImpl service = new ProtitlesServiceImpl();
        if(protitleName != null){
            try {
                service.save(protitleName, protitleDescription);
                //3.頁面導航
                //沒有異常
                resp.sendRedirect("/prot/protlist");

            } catch (Exception e) {
                e.printStackTrace();
                /*throw new RuntimeException(e);*/
                //保存失敗
                resp.sendRedirect("/prot/protadd");


            } /*finally {
        }*/
        }
        else{
            System.out.println("protitleName 不能為空！");
        }
    }

}
