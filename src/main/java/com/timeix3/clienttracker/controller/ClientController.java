package com.timeix3.clienttracker.controller;

import com.timeix3.clienttracker.dto.ClientResponse;
import com.timeix3.clienttracker.dto.CreateClientRequest;
import com.timeix3.clienttracker.dto.UpdateClientRequest;
import com.timeix3.clienttracker.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Void> createNewClient(@RequestBody @Valid CreateClientRequest request){
        ClientResponse created = clientService.create(request);
        return ResponseEntity.created(URI.create("/api/clients/"+created.id())).build();
    }

    @GetMapping
    public List<ClientResponse> getAllClients(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ClientResponse getClientById(@PathVariable Long id){
        return clientService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClientById(@PathVariable Long id, @Valid @RequestBody UpdateClientRequest request){
        clientService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
