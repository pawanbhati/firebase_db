package com.pawan.firebasedatabase.models;

import java.util.List;

public class Products {

    List<Items> productList;

    public List<Items> getProductList() {
        return productList;
    }

    public void setProductList(List<Items> productList) {
        this.productList = productList;
    }
}
