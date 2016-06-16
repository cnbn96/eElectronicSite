/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3h.ecommerce.servlet;

import com.t3h.ecommerce.entity.Category;
import com.t3h.ecommerce.entity.Product;
import com.t3h.ecommerce.service.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BINH
 */
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int onPageProducts = 10;
        Connection con = DatabaseConnection.mySQLConnection();
        Statement stm = con.createStatement();
        out.println("before sql query");
        ResultSet rs = stm.executeQuery("select * from ecom_product order by maker_date limit "+ onPageProducts);
        List<Product> listProducts = new ArrayList<>();
        while (rs.next()) {
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            double productPrice = rs.getInt("product_price");
            double productPricePromotion = rs.getInt("product_price_promotion");
            String productImage = rs.getString("product_image");
            String productDescription = rs.getString("description");
            int productCategoryId = rs.getInt("product_category_id");
            Category category = null;
            out.println(productName);
            Statement stm1 = con.createStatement();
            ResultSet rsinner = stm1.executeQuery("select * from ecom_product_category where product_category_id ='" + productCategoryId+"'");
            while (rsinner.next()) {
                int categoryId = rsinner.getInt("product_category_id");
                String categoryName = rsinner.getString("category_name");                                              
                String categoryDescription = rsinner.getString("description");
                category = new Category(categoryId, categoryName, categoryDescription);                
            }
            //Timestamp productMakerDate = rs.getTimestamp("maker_date");
            Timestamp productMakerDate = new Timestamp(System.currentTimeMillis());
            Product pr = new Product(productId, productName, productPrice, productPricePromotion, productDescription, productImage, productMakerDate, productName);
            pr.setProductCategory(category);           
            listProducts.add(pr);            
        }
        out.println("tt");
        request.setAttribute("listProducts", listProducts);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
