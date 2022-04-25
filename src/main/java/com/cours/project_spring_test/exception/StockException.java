package com.cours.project_spring_test.exception;

import com.cours.project_spring_test.model.Product;

public class StockException extends Exception {
    public StockException(final Product pProduct) {

        super("Pas assez de " + pProduct.getName());

    }
}
