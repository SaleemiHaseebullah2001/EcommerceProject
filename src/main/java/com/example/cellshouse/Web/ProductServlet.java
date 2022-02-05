package com.example.cellshouse.Web;

import com.example.cellshouse.DAO.ProductDAO;
import com.example.cellshouse.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;

    public ProductServlet(){
        this.productDAO = new ProductDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/shop":
                    productList(request, response);
                    break;
                case "/single-product":
                    getProduct(request,response);
                    break;
                default:
                    break;
            }
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

    private void getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.getProductById(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("single-product.jsp");
        requestDispatcher.forward(request,response);
    }
}
