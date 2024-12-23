package com.ustb.hospital.servlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig
@WebServlet("/doc/add")
public class FileUploadServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String docname = req.getParameter("docname");
        Part part = req.getPart("docavatar");
        String sfn = part.getSubmittedFileName();
        String name = part.getName();
        System.out.println("docname:"+docname);
        System.out.println("文件名:"+sfn);
        String houzhui = sfn.substring(sfn.lastIndexOf("."));

        String newname = UUID.randomUUID().toString().replaceAll("-","");
        String Sfn = newname + houzhui;
        //保存文件
/*        String uploadImgPath = this.getServletContext().getRealPath("/images/docavatar/");
        File file = new File(uploadImgPath);*/
/*        if(!file.exists())
        {
            file.createNewFile();
        }*/
        part.write("C:\\Java\\zhwzj\\src\\main\\webapp\\images\\docavatar\\"+Sfn);
        /*part.write(uploadImgPath+Sfn);*/

    }
}

