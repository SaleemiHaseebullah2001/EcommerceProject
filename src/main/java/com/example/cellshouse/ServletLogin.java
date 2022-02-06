package com.example.cellshouse;

import com.example.cellshouse.DAO.CartDAO;
import com.example.cellshouse.Model.cart_item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.StringTokenizer;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    private CartDAO cartDAO;

    public ServletLogin(){
        this.cartDAO = new CartDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userid = login.AutenticaUser(request.getParameter("email"),request.getParameter("password"));

        if(userid == -1){
            request.setAttribute("errorLabel", "Email o password errati");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{

            request.setAttribute("userid", userid);
            request.getRequestDispatcher("profile.jsp").forward(request, response);


            HttpSession session= request.getSession();
            session.setAttribute("userid",userid);
            session.setAttribute("UserPassword",request.getParameter("password"));
            List<cart_item> cart = (List<cart_item>) session.getAttribute("cart");
            if (cart != null || Objects.requireNonNull(cart).size() > 0) {
                for (cart_item item : cart) {
                    int itemid = item.getProduct().getId();
                    int quantity = item.getQuantity();
                    userid = Integer.parseInt((String) session.getAttribute("userid"));
                    try {
                        cartDAO.insertCartItem(itemid,userid,quantity);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
