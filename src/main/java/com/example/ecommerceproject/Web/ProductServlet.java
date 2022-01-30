package com.example.ecommerceproject.Web;

import com.example.ecommerceproject.DAO.ProductDAO;
import com.example.ecommerceproject.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/shop")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;
    public ProductServlet(){
        this.productDAO = new ProductDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            productList(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List <Product> products = productDAO.getAllProducts();
        System.out.println(products);
        request.setAttribute("productlist", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request,response);
    }
}
