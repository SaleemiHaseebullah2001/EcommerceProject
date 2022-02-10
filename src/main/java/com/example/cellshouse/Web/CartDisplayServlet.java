package com.example.cellshouse.Web;

import com.example.cellshouse.DAO.CartDAO;
import com.example.cellshouse.DAO.ProductDAO;
import com.example.cellshouse.Model.Login;
import com.example.cellshouse.Model.Product;
import com.example.cellshouse.Model.cart_item;
import com.example.cellshouse.Model.cart_item_row;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartDisplayServlet", value = "/cart")
public class CartDisplayServlet extends HttpServlet {
    private final CartDAO  cartDAO;
    private final ProductDAO productDAO;
    public CartDisplayServlet(){
        cartDAO = new CartDAO();
    productDAO = new ProductDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            doGet_DisplayCart(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("user"));
        List <cart_item> cart_items = new ArrayList<>();
        if (session.getAttribute("user") != null){
            System.out.println("calling from cart");
            Login user = (Login) session.getAttribute("user");
            List <cart_item_row> cart_item_rows = cartDAO.getCartById(user.getId());
            System.out.println("Cart item rows" + cart_item_rows.size());
            for (cart_item_row itemRow: cart_item_rows){
                Product product = productDAO.getProductById(itemRow.getId_item());
                cart_items.add(new cart_item(product, itemRow.getQuantity()));
            }
            System.out.println("Cart items" + cart_items.size());
            session.setAttribute("cart", cart_items);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
            requestDispatcher.forward(request,response);
        }else {
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
