package com.evervc.springboot.di.factura.spingbootdifactura.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {

    private Product product;

    private Integer quantity;

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Item() {
    }

    public double getAmount() {
        return quantity * product.getPrice();
    }

}
