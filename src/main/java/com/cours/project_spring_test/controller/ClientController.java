package com.cours.project_spring_test.controller;

import com.cours.project_spring_test.model.Client;
import com.cours.project_spring_test.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long id) {
        Optional<Client> optionalClient = clientService.getClientById(id);
        return optionalClient.map(client -> ResponseEntity.ok().body(client)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Client saveClient(@RequestParam("username") String username, //
                           @RequestParam("password") String password) {
        final Client newClient = new Client();
        newClient.setUsername(username);
        newClient.setPassword(password);
        return clientService.save(newClient);
    }

    @PutMapping("/update-username/{id}")
    public void updateUsername(@PathVariable(value = "id") Long id, //
                             @RequestParam("username") String username) {
        if (username != null) {
            clientService.updateUsername(username, id);
        }
    }


    @PutMapping("/update-password/{id}")
    public void updatePassword(@PathVariable(value = "id") Long id, //
                               @RequestParam("password") String password) {
        if (password != null) {
            clientService.updatePassword(password, id);
        }
    }
}
