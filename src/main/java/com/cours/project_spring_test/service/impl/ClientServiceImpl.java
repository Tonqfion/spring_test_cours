package com.cours.project_spring_test.service.impl;

import com.cours.project_spring_test.model.Client;
import com.cours.project_spring_test.repository.ClientRepository;
import com.cours.project_spring_test.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("clients")
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final List<Client> allClients = new ArrayList<>();

    public ClientServiceImpl(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

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