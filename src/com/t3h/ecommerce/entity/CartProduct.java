/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t3h.ecommerce.entity;

import java.sql.Timestamp;

/**
 *
 * @author BINH
 */
public class CartProduct extends Product{
    private int cartQuantity;

    public CartProduct() {
    }
    public CartProduct(Product pr,int cartQuantity) {
        super(pr.getProductId(), pr.getProductName(), pr.getProductPrice(), pr.getProductPricePromotion(), pr.getProductDescription(), pr.getProductImage(), pr.getProductMakerDate(), pr.getProductMaker());
        this.cartQuantity = cartQuantity;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
    
    
}
