package com.example.cellshouse.Web;
import com.example.cellshouse.DAO.ProductDAO;
import  com.example.cellshouse.Model.cart_item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CartServlet", value = "/add_item")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println("Cart action test" + action);
        try {
            switch (action) {
                case "/add_itemghghg":
                    doGet_AddToCart(request, response);
                    break;
//                case "/remove_item":
//                    doGet_Remove(request,response);
//                    break;
                default:
                    doGet_AddToCart(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher("cart/index.jsp").forward(request, response);
//    }
//
//    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//
//
//        List<cart_item> cart = (List<cart_item>) session.getAttribute("cart");
//        int index = isExisting(request.getParameter("id"), cart);
//        cart.remove(index);
//        session.setAttribute("cart", cart);
//        response.sendRedirect("cart");
//    }

    protected void doGet_AddToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        ProductDAO productDAO = new ProductDAO();
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            List <cart_item> cart = new ArrayList <cart_item>();
            cart.add(new cart_item(productDAO.getProductById(Integer.parseInt(request.getParameter("id"))), 1));
            session.setAttribute("cart", cart);
        } else {
            List<cart_item> cart = (List<cart_item>) session.getAttribute("cart");
            int index = isExisting(request.getParameter("id"), cart);
            if (index == -1) {
                cart.add(new cart_item(productDAO.getProductById(Integer.parseInt(request.getParameter("id"))), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        List<cart_item> cart = (List<cart_item>) session.getAttribute("cart");
        for (cart_item item: cart
             ) {
            System.out.println(item.getProduct().getName() + " "+ item.getQuantity());
        }
        request.setAttribute("message","product added to cart");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("single-product?id=" + request.getParameter("id"));
        requestDispatcher.forward(request,response);
//        response.sendRedirect("single-product?id=" + request.getParameter("id"));
    }

    private int isExisting(String id, List<cart_item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == Integer.parseInt(id)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt((request.getParameter("quantity")));
        System.out.println("id" + "quantity");
        HttpSession session = request.getSession();
        List<cart_item> cart = (List<cart_item>) session.getAttribute("cart");
        for (cart_item item : cart
        ) {
            if (item.getProduct().getId() == id) {
            item.setQuantity(quantity);
            }
        }
        session.setAttribute("cart", cart);
    }
}
