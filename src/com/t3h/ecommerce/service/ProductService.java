/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3h.ecommerce.service;

import com.t3h.ecommerce.entity.Category;
import com.t3h.ecommerce.entity.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BINH
 */
public class ProductService {
    public static Product GetProduct(String sql) throws ClassNotFoundException, SQLException{
        Connection con = DatabaseConnection.mySQLConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        Product pr = new Product();
        while(rs.next()){
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            double productPrice = rs.getInt("product_price");
            double productPricePromotion = rs.getInt("product_price_promotion");
            String productImage = rs.getString("product_image");
            String productDescription = rs.getString("description");
            int productCategoryId = rs.getInt("product_category_id");
            Category category = null;
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
            pr = new Product(productId, productName, productPrice, productPricePromotion, productDescription, productImage, productMakerDate, productName);
            pr.setProductCategory(category);
        }
        con.close();
        return pr;
    }
    public static List<Product> GetProducts(String sql) throws ClassNotFoundException, SQLException{
        Connection con = DatabaseConnection.mySQLConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Product> listProducts = new ArrayList<>();
        while(rs.next()){
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            double productPrice = rs.getInt("product_price");
            double productPricePromotion = rs.getInt("product_price_promotion");
            String productImage = rs.getString("product_image");
            String productDescription = rs.getString("description");
            int productCategoryId = rs.getInt("product_category_id");
            Category category = null;
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
        con.close();
        return listProducts;
    }
}
