package com.example.cellshouse.Web;

import com.example.cellshouse.DAO.CartDAO;
import com.example.cellshouse.DAO.LoginDAO;
import com.example.cellshouse.Model.Login;
import com.example.cellshouse.Model.cart_item;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final CartDAO cartDAO;

    public LoginServlet(){
        this.cartDAO = new CartDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginDAO userDao = new LoginDAO();

        try {
            Login user = userDao.checkLogin(email, password);
            String destPage = "login.jsp";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                if (session.getAttribute("cart") != null ){
                    List<cart_item> cart = (List<cart_item>) session.getAttribute("cart");
                    if (cart != null || Objects.requireNonNull(cart).size() > 0) {
                        for (cart_item item : cart) {
                            int itemid = item.getProduct().getId();
                            int quantity = item.getQuantity();
                            int userid = user.getId();
                            try {
                                cartDAO.insertCartItem(itemid,userid,quantity);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
//                        session.setAttribute("cart",null);
                    }
                    destPage = "cart.jsp";
                }
                else{
                    request.setAttribute("useremail","Ciao " + user.getEmail());
                    destPage = "index.jsp";
                }

            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

}
