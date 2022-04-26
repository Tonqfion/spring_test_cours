package com.cours.project_spring_test.service;

import com.cours.project_spring_test.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAllClients();
    Optional<Client> getClientById(final Long id);
    Client save(final Client client);

    void updatePassword(final String updatedPassword, final Long id);
    void updateUsername(final String updatedUsername, final Long id);
}
