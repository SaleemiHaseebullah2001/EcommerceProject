package com.example.cellshouse.Web;

import com.example.cellshouse.DAO.CartDAO;
import com.example.cellshouse.DAO.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckoutServlet", value = "/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    checkout(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    private void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request,response);
        } else {


            RequestDispatcher requestDispatcher = request.getRequestDispatcher("checkout.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
