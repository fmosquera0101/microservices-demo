package com.store.productservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "products")
public class ProductEntity {

    @Id
    private String productId;

    private String name;
    private int quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
