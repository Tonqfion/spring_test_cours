package com.cours.project_spring_test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, name = "name", nullable = false)
    private String name;


    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "picture", nullable = true)
    private String picture;

    @Column(name = "available-quantity", nullable = false)
    private Integer availableQuantity;

    public Product() {
        super();
    }

    public Product(final Long pId, final String pName, final String pDescription, final Double pPrice, final String pPicture, final Integer pAvailableQuantity) {
        id = pId;
        name = pName;
        description = pDescription;
        price = pPrice;
        picture = pPicture;
        availableQuantity = pAvailableQuantity;
    }
}
