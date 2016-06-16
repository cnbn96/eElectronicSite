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
public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private double productPricePromotion;
    private String productDescription;
    private Category productCategory;
    private String productImage;
    private Timestamp productMakerDate;
    private String productMaker;

    public Product() {
    }

    public Product(int productId, String productName, double productPrice, double productPricePromotion, String productDescription, String productImage, Timestamp productMakerDate, String productMaker) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productPricePromotion = productPricePromotion;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productMakerDate = productMakerDate;
        this.productMaker = productMaker;
    }

    

    public int getProductId() {
        return productId;
    }

    public void setProductId(int id) {
        this.productId = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductPricePromotion() {
        return productPricePromotion;
    }

    public void setProductPricePromotion(double productPricePromotion) {
        this.productPricePromotion = productPricePromotion;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Timestamp getProductMakerDate() {
        return productMakerDate;
    }

    public void setProductMakerDate(Timestamp productMakerDate) {
        this.productMakerDate = productMakerDate;
    }

    public String getProductMaker() {
        return productMaker;
    }

    public void setProductMaker(String productMaker) {
        this.productMaker = productMaker;
    }
    
    
}
