package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("sign.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        PrintWriter printWriter=resp.getWriter();
        JDBCMethod jdbcMethod=new JDBCMethod();
        User user=jdbcMethod.loginUser(username,password);
        if(user==null){
            printWriter.write("<h1 style=' color:red'>Username yoki Parol xato</h1>");
            resp.sendRedirect("register.html");
        }else{
            printWriter.write("<h1>Kabinetga xush kelibsiz!"+username+"</h1>");
        }
    }
}
