package com.example.ecommerceproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletRegister", value = "/ServletRegister")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String test="no";
        if(request.getParameter("password").equals(request.getParameter("pass-repeat"))){
            test=register.registraAccount(request.getParameter("email"),request.getParameter("password"));

        }
        if(test.equals("si")){
            response.sendRedirect("index.jsp");

        }
        if(test.contains("no")){
            response.sendRedirect("signup.jsp");
        }

    }
}
