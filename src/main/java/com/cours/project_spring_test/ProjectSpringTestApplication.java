package com.cours.project_spring_test;

import com.cours.project_spring_test.exception.StockException;
import com.cours.project_spring_test.model.Client;
import com.cours.project_spring_test.model.Order;
import com.cours.project_spring_test.model.Product;
import com.cours.project_spring_test.service.ClientService;
import com.cours.project_spring_test.service.OrderService;
import com.cours.project_spring_test.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;

//@SpringBootApplication
@ComponentScan("com.*")
public class ProjectSpringTestApplication {

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectSpringTestApplication.class))
        {
            final ClientService clientService = context.getBean("clients", ClientService.class);

            final OrderService orderService = context.getBean("orders", OrderService.class);

            final ProductService productService = context.getBean("products", ProductService.class);

            final Product chaussettes = new Product(1L, "Chaussettes", "Des chaussettes", 19.99, "chausettes.jpg", 500);
            final Product chaussures = new Product(2L, "Chaussures", "Des chaussures", 29.99, "chaussures.jpg", 100);
            final Product casquette = new Product(3L, "Casquette", "Une casquette", 59.99, "casquette.jpg", 20);

            final Client leDeuxiemeClient = new Client(2L, "Le Deuxieme Client", "gnagna");

            clientService.save(leDeuxiemeClient);
            final Order laDeuxiemeCommande = new Order(2L, "ongoing", LocalDate.now(), leDeuxiemeClient);

            productService.save(chaussettes);
            productService.save(chaussures);
            productService.save(casquette);

            laDeuxiemeCommande.addProduct(chaussettes, 2);
            laDeuxiemeCommande.addProduct(casquette, 50);

            productService.getAllProducts().forEach(System.out::println);
            orderService.create(laDeuxiemeCommande);
            System.out.println(laDeuxiemeCommande.getStatus());
            try {
                orderService.update(laDeuxiemeCommande);
            } catch(StockException exception) {
                System.err.println(exception.getMessage());
            }

            try {
                orderService.update(laDeuxiemeCommande);
            } catch(StockException exception) {
                System.err.println(exception.getMessage());
            }

            System.out.println(laDeuxiemeCommande.getStatus());
            System.out.println(chaussettes.getAvailableQuantity());
            System.out.println(casquette.getAvailableQuantity());

        }
    }
/*
    public static void mainTP2(String[] args) {
        SpringApplication.run(ProjectSpringTestApplication.class, args);

        try (final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("services.xml"))
        {
            final ClientService clientService = context.getBean("clients", ClientService.class);

            final OrderService orderService = context.getBean("orders", OrderService.class);

            final ProductService productService = context.getBean("products", ProductService.class);

            final Product chaussettes = new Product(1L, "Chaussettes", "Des chaussettes", 19.99, "chausettes.jpg", 500);
            final Product chaussures = new Product(2L, "Chaussures", "Des chaussures", 29.99, "chaussures.jpg", 100);
            final Product casquette = new Product(3L, "Casquette", "Une casquette", 59.99, "casquette.jpg", 20);

            final Client leDeuxiemeClient = new Client(2L, "Le Deuxieme Client", "gnagna");

            clientService.save(leDeuxiemeClient);
            final Order laDeuxiemeCommande = new Order(2L, "ongoing", LocalDate.now(), leDeuxiemeClient);

            productService.save(chaussettes);
            productService.save(chaussures);
            productService.save(casquette);

            laDeuxiemeCommande.addProduct(chaussettes, 2);
            laDeuxiemeCommande.addProduct(casquette, 5);

            productService.getAllProducts().forEach(System.out::println);
            orderService.create(laDeuxiemeCommande);
            System.out.println(laDeuxiemeCommande.getStatus());
            try {
                orderService.update(laDeuxiemeCommande);
            } catch(StockException exception) {
                System.err.println(exception.getMessage());
            }

            try {
                orderService.update(laDeuxiemeCommande);
            } catch(StockException exception) {
                System.err.println(exception.getMessage());
            }

            System.out.println(laDeuxiemeCommande.getStatus());
            System.out.println(chaussettes.getAvailableQuantity());
            System.out.println(casquette.getAvailableQuantity());

        }


    }


 */
//
//    public static void main(String[] args) {
//
//        final Product chaussettes = new Product();
//        chaussettes.setId(1L);
//        chaussettes.setName("Chaussettes");
//        chaussettes.setDescription("Des chaussettes");
//        chaussettes.setPrice(19.99);
//        chaussettes.setPicture("chaussettes.jpg");
//        chaussettes.setAvailableQuantity(2000);
//
//        final Product chaussures = new Product();
//        chaussures.setId(2L);
//        chaussures.setName("Chaussures");
//        chaussures.setDescription("Des chaussures");
//        chaussures.setPrice(39.99);
//        chaussures.setPicture("chaussures.jpg");
//        chaussures.setAvailableQuantity(1000);
//
//        final Client leClient = new Client();
//        leClient.setId(1L);
//        leClient.setUsername("Le Premier Client");
//        leClient.setPassword("lalala");
//
//        final Order laCommande = new Order();
//        laCommande.setId(1L);
//        laCommande.setDateCreated(LocalDate.now());
//        laCommande.setStatus("ongoing");
//        laCommande.setClient(leClient);
//        laCommande.setOrderProductsList(new ArrayList<>());
//
//        System.out.println(laCommande);
//        laCommande.addProduct(chaussettes, 2);
//        laCommande.addProduct(chaussettes, 3);
//
//        System.out.println(laCommande);
//        laCommande.addProduct(chaussures,3);
//        laCommande.setStatus("paid");
//
//        System.out.println(laCommande);
//
//        final Product lunettes = new Product(3L, "lunettes", "Des lunettes", 159.99, "lunettes.jpg", 200);
//        final Client leDeuxiemeClient = new Client(2L, "Le Deuxieme Client", "gnagna");
//        final Order laDeuxiemeCommande = new Order(2L, "ongoing", LocalDate.now(), leDeuxiemeClient);
//        laDeuxiemeCommande.addProduct(chaussettes, 20);
//        laDeuxiemeCommande.addProduct(lunettes, 505);
//        System.out.println(laDeuxiemeCommande);
//    }

}
