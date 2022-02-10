package com.example.cellshouse.Web;

import com.example.cellshouse.DAO.LoginDAO;
import com.example.cellshouse.DAO.RegisterDAO;
import com.example.cellshouse.Model.Login;
import com.example.cellshouse.Model.RegisterBean;
import com.example.cellshouse.Model.cart_item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            Login user = (Login) session.getAttribute("user");
            RegisterDAO registerDAO = new RegisterDAO();
            try {
                RegisterBean userdata = registerDAO.getUserDataById(user.getId());
                request.setAttribute("userdata", userdata);
                RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String confirmpassword = request.getParameter("confirmpassword");

        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            Login user = (Login) session.getAttribute("user");
            RegisterDAO registerDAO = new RegisterDAO();
            try {
                RegisterBean userdata = registerDAO.getUserDataById(user.getId());
                System.out.println(oldpassword +" " + userdata.getPassword() );
                if (oldpassword.equals(userdata.getPassword())){
                    if (newpassword.equals(confirmpassword)){
                        boolean status = registerDAO.updatePassword(user.getId(),newpassword,confirmpassword);
                        if (status){
                            request.setAttribute("message","Password Updated Successfully");
                            request.setAttribute("userdata",userdata);
                        }else {
                            request.setAttribute("msg1", "Something Went Wrong");
                            request.setAttribute("userdata", userdata);
                        }
                    }else{
                        request.setAttribute("msg", "password does not match");
                        request.setAttribute("userdata", userdata);
                    }
                }else {
                    request.setAttribute("msg", "old Password is wrong");
                    request.setAttribute("userdata", userdata);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
