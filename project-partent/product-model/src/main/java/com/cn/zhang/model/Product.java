package com.cn.zhang.model;

import java.io.Serializable;

public class Product implements Serializable {



    private Long id;

    private String product;

    private String dbSource;


    public Product() {
    }

    public Product(String product) {
        this.product = product;
    }

    public Product(Long id, String product, String dbSource) {
        this.id = id;
        this.product = product;
        this.dbSource = dbSource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", dbSource='" + dbSource + '\'' +
                '}';
    }

}
