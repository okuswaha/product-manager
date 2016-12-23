package com.prakash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by okuswaha on 12/23/2016.
 */
@Entity(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Column(name = "SKU")
    private String sku;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_DESC")
    private String productDesc;
    @Column(name = "CATEGORY_ID")
    private int categoryId;
    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

    public Product(int productId, String sku, String productName, String productDesc, int categoryId, BigDecimal unitPrice) {
        this.productId = productId;
        this.sku = sku;
        this.productName = productName;
        this.productDesc = productDesc;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", sku='" + sku + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", categoryId=" + categoryId +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
