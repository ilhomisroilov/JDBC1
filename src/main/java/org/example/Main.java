package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.html");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBCMethod jdbcMethod=new JDBCMethod();
        PrintWriter printwriter = resp.getWriter();
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user=new User(firstname,lastname,username,password);
        jdbcMethod.saveUser(user);
        boolean register=jdbcMethod.saveUser(user);
        if(register){
            printwriter.write("<h1>Muvaffaqiyatli qo'shildi");
        }else{
            printwriter.write("<h1>Qo'shilamdi</h1>");
        }
    }
}