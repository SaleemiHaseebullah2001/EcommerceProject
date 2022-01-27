package com.example.ecommerceproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email=login.AutenticaUser(request.getParameter("email"),request.getParameter("password"));

        if(email.equals("sbagliato")){
            request.setAttribute("errorLabel", "Email o password errati");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{

            request.setAttribute("profileEmail", email);
            request.getRequestDispatcher("profile.jsp").forward(request, response);


            HttpSession session= request.getSession();
            session.setAttribute("UserEmail",email);
            session.setAttribute("UserPassword",request.getParameter("password"));
        }
    }
}
