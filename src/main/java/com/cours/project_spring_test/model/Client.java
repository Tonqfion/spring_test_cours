package com.cours.project_spring_test.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {

    private Long id;

    private String username;

    private String password;

    public Client() {
        super();
    }

    public Client(final Long pId, final String pUsername, final String pPassword) {
        id = pId;
        username = pUsername;
        password = pPassword;
    }
}
