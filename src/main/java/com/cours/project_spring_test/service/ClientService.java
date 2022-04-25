package com.cours.project_spring_test.service;

import com.cours.project_spring_test.exception.ResourceNotFoundException;
import com.cours.project_spring_test.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(final Long id) throws ResourceNotFoundException;
    Client save(final Client client);

}
