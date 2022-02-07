package com.example.cellshouse.Web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.cellshouse.Model.RegisterBean;
import com.example.cellshouse.DAO.RegisterDAO;
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String pnumber = request.getParameter("pnumber");
        String gender = request.getParameter("gender");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        String city = request.getParameter("city");
        String zip = request.getParameter("zip");
        String state = request.getParameter("state");


        RegisterBean registerBean = new RegisterBean();
        //Using Java Beans - An easiest way to play with group of related data
        registerBean.setEmail(email);
        registerBean.setPassword(password);
        registerBean.setName(name);
        registerBean.setSurname(surname);
        registerBean.setPnumber(pnumber);
        registerBean.setGender(gender);
        registerBean.setStreet(street);
        registerBean.setNumber(number);
        registerBean.setCity(city);
        registerBean.setZip(zip);
        registerBean.setZip(state);

        RegisterDAO registerDao = new RegisterDAO();

        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = null;
        try {
            userRegistered = registerDao.registerUser(registerBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }

}
