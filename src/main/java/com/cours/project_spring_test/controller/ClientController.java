package com.cours.project_spring_test.controller;

import com.cours.project_spring_test.model.Client;
import com.cours.project_spring_test.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    ClientService clientService;

    @Autowired
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {return clientService.getAllClients();}

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long id) {
        Optional<Client> optionalClient = clientService.getClientById(id);
        return optionalClient.map(client -> ResponseEntity.ok().body(client)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/save")


}
