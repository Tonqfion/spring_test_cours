package com.cours.project_spring_test;

import com.cours.project_spring_test.model.Client;
import com.cours.project_spring_test.model.Order;
import com.cours.project_spring_test.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class ProjectSpringTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSpringTestApplication.class, args);
    }
//
//    public static void main(String[] args) {
//
//        final Product chaussettes = new Product();
//        chaussettes.setId(1L);
//        chaussettes.setName("Chaussettes");
//        chaussettes.setDescription("Des chaussettes");
//        chaussettes.setPrice(19.99);
//        chaussettes.setPicture("chaussettes.jpg");
//        chaussettes.setQuantity(2000);
//
//        final Product chaussures = new Product();
//        chaussures.setId(2L);
//        chaussures.setName("Chaussures");
//        chaussures.setDescription("Des chaussures");
//        chaussures.setPrice(39.99);
//        chaussures.setPicture("chaussures.jpg");
//        chaussures.setQuantity(1000);
//
//        final Client leClient = new Client();
//        leClient.setId(1L);
//        leClient.setUsername("Le Premier Client");
//        leClient.setPassword("lalala");
//
//        final Order laCommande = new Order();
//        laCommande.setId(1L);
//        laCommande.setDateCreated(LocalDate.now());
//        laCommande.setClient(leClient);
//        laCommande.setOrderProductsList(new ArrayList<>());
//
//        System.out.println(laCommande);
//        laCommande.addProduct(chaussettes, 2);
//        laCommande.addProduct(chaussettes, 3);
//
//        System.out.println(laCommande);
//        laCommande.addProduct(chaussures,3);
//        laCommande.setStatus("payé");
//
//        System.out.println(laCommande);
//
//        final Product lunettes = new Product(3L, "lunettes", "Des lunettes", 159.99, "lunettes.jpg", 200);
//        final Client leDeuxiemeClient = new Client(2L, "Le Deuxieme Client", "gnagna");
//        final Order laDeuxiemeCommande = new Order(2L, leDeuxiemeClient);
//        laDeuxiemeCommande.addProduct(chaussettes, 20);
//        laDeuxiemeCommande.addProduct(lunettes, 505);
//        System.out.println(laDeuxiemeCommande);
//    }

}
