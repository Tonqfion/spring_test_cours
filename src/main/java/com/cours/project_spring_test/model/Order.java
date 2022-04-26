package com.cours.project_spring_test.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "table_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_created", columnDefinition = "DATE", nullable = false)
    private LocalDate dateCreated;

    @Column(name = "status", length = 20)
    @ColumnDefault("ongoing")
    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderProduct> orderProducts;
}
