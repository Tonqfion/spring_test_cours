package com.cours.project_spring_test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, name = "username", nullable = false)
    private String username;

    @Column(length = 100, name = "password", nullable = false)
    private String password;
}
