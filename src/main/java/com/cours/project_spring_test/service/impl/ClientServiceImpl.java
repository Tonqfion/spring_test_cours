package com.cours.project_spring_test.service.impl;

import com.cours.project_spring_test.model.Client;
import com.cours.project_spring_test.repository.ClientRepository;
import com.cours.project_spring_test.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    private final List<Client> allClients = new ArrayList<>();

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(final Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client save(final Client client) {
        return clientRepository.save(client);
    }
}