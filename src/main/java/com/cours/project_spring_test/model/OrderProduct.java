package com.cours.project_spring_test.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProduct {

    private Product product;

    private Order order;

    private Integer quantity;

    public OrderProduct() {
        super();
    }

    public OrderProduct(Product pProduct, Order pOrder, Integer pQuantity){
        product = pProduct;
        order = pOrder;
        quantity = pQuantity;
    }

    public Double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "------------------------- \n" + //
        "Produit commandé : " + product.getName() + "\n" + //
        "Quantité commandée : " + quantity + "\n" + //
        "Prix total : " + getTotalPrice() + " euros \n" + //
        "------------------------- \n";
    }

}
