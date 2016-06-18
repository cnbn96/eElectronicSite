/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3h.ecommerce.entity;

import com.t3h.ecommerce.service.ProductService;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author BINH
 */
public class Cart implements Serializable{
    Map<Integer, CartProduct> listProduct = null;
    public Cart(){
        listProduct = new Hashtable<>();
    }
    public Map<Integer, CartProduct> getListProduct(){
        return listProduct;
    }
    public void setListProduct(int productId, int cartQuantity) throws ClassNotFoundException, SQLException{
        CartProduct cpr = null;
        if(listProduct.containsKey(productId)){
            cpr = listProduct.get(productId);
            cpr.setCartQuantity(cpr.getCartQuantity()+ cartQuantity);
        }else{
            Product product = ProductService.GetProduct("select * from ecom_product where product_id='"+productId+"'");
            cpr = new CartProduct(product, cartQuantity);
            listProduct.put(productId, cpr);
        }
    }
    public int getCartSize(){
        return listProduct.size();
    }
}
