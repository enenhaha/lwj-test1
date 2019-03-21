package com.lwj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet 获得填写的表单数据
 */
@WebServlet("/demo")
public class demo extends HttpServlet {
    //private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//编码
        
      //获取传过来的表单数据,根据表单中的name获取所填写的值
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String[] hobbys = request.getParameterValues("hobby");
        
        System.out.println(request.getRequestURL());//获取客户端发出请求完整URL
        System.out.println(request.getRemoteAddr());//获取ip地址
        System.out.println(request.getContextPath ());//当前web应用虚拟目录名称
        
        System.out.println(userName);
        System.out.println(pwd);
        System.out.println(sex);
        for (int i = 0; hobbys!=null&&i < hobbys.length; i++) {
            System.out.println(hobbys[i]+"\t");
        }

        response.setStatus(200);
        //response.setHeader("Location", "/web");  跳转
        response.getOutputStream().write("{state:1,msg:ok}".getBytes());
        //response.getOutputStream().write("<script>alert('提交成功');window.location.href='/web';</script>".getBytes());

        
//        URLEncoder.encode("xxxx","utf-8");//url编码
//        URLDecoder.decode(str,"utf-8");//url解码

        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}