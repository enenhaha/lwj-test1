package com.lwj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet 获得填写的表单数据
 */
@WebServlet("/test")
public class test extends HttpServlet {
    //private static final long serialVersionUID = 1L;

 	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://119.29.222.105:3306/0517";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456789";
    

    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//首先设置可以处理中文
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=utf-8");//html


		
		Connection conn = null;
	    Statement stmt = null;
	    
	    String Json = "[";
	    
	    try{
	        // 注册 JDBC 驱动
	        Class.forName("com.mysql.jdbc.Driver");

	        // 打开链接
	        System.out.println("连接数据库...");
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);

	        // 执行查询
	        System.out.println(" 实例化Statement对象...");
	        stmt = conn.createStatement();
	        String sql;
	        sql = "SELECT * FROM user";
	        ResultSet rs = stmt.executeQuery(sql);

	        
	        // 展开结果集数据库
	        while(rs.next()){
	        	
	        	int id  = rs.getInt("id");
	            String name = rs.getString("username");
	            
	            
	            // 通过字段检索
	        	Json += "{\"ID\":"+"\""+id+"\"";
	        	Json += ",\"name\":"+"\""+name+"\"";
	        	
	        	
	        	//System.out.println(rs.getString(1));
	        	//System.out.println(rs.getString(2));
	        	
	        	

	            // 输出数据
	            //System.out.print("ID: " + id);
	            //System.out.print(", 名称: " + name);
	            //System.out.print("\n");
	            
	            Json += "},";
	            
	        }
	        Json = Json.substring(0,Json.length()-1);
	        Json += "]";
	        System.out.println(Json);
	        // 完成后关闭
	        rs.close();
	        stmt.close();
	        conn.close();
	    }catch(SQLException se){
	        // 处理 JDBC 错误
	        se.printStackTrace();
	    }catch(Exception e){
	        // 处理 Class.forName 错误
	        e.printStackTrace();
	    }finally{
	        // 关闭资源
	        try{
	            if(stmt!=null) stmt.close();
	        }catch(SQLException se2){
	        }// 什么都不做
	        try{
	            if(conn!=null) conn.close();
	        }catch(SQLException se){
	            se.printStackTrace();
	        }
	    }
	    System.out.println("Goodbye!");
	    
	    
	    
	    
	    
	    
	    
        String userName = request.getParameter("aa");
        String pwd = request.getParameter("bb");
        
    	//response.setStatus(200);
        //response.getOutputStream().write("ok".getBytes());
        
        response.getWriter().append(Json);
        //response.getWriter().append("{\"msg\":\"ok\"}");

        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}