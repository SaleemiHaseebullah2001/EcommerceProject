package com.example.cellshouse.Web;

import com.example.cellshouse.Model.cart_item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CartRemoveServlet", value = "/remove_item")
public class CartRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet_Remove(request,response);
    }
    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();


        List<cart_item> cart = (List<cart_item>) session.getAttribute("cart");
        if(cart.size() > 0){
            int index = isExisting(request.getParameter("id"), cart);
            cart.remove(index);
        }
        session.setAttribute("cart", cart);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart");
        requestDispatcher.forward(request,response);
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

    }
}
