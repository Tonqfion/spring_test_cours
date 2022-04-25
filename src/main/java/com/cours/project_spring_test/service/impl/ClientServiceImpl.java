package com.cours.project_spring_test.service.impl;

import com.cours.project_spring_test.exception.ResourceNotFoundException;
import com.cours.project_spring_test.model.Client;
import com.cours.project_spring_test.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private final List<Client> allClients = new ArrayList<>();

    @Override
    public List<Client> getAllClients() {
        return allClients;
    }

    @Override
    public Client getClientById(final Long id) throws ResourceNotFoundException {
        final Optional<Client> optClientById = allClients.stream().filter(client -> client.getId().equals(id)).findFirst();
        if (optClientById.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return optClientById.get();
    }

    @Override
    public Client save(final Client client) {
        if (client != null) {
            allClients.add(client);
        }
        return client;
    }
}
