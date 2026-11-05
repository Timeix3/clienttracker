package com.timeix3.clienttracker.service;

import com.timeix3.clienttracker.dto.ClientResponse;
import com.timeix3.clienttracker.dto.CreateClientRequest;
import com.timeix3.clienttracker.dto.UpdateClientRequest;
import com.timeix3.clienttracker.entity.Client;
import com.timeix3.clienttracker.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional
    public ClientResponse create(CreateClientRequest request){
        Client client = new Client();
        client.setFullName(request.fullName());
        client.setGender(request.gender());
        client.setStatus("ACTIVE");
        clientRepository.save(client);
        return new ClientResponse(client.getId(), client.getFullName(), client.getGender(), client.getStatus());
    }

    @Transactional(readOnly = true)
    public ClientResponse getById(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Клиент с id = " + clientId + " не найден"));
        return new ClientResponse(clientId, client.getFullName(), client.getGender(), client.getStatus());
    }

    @Transactional(readOnly = true)
    public List<ClientResponse> getAll() {
        return clientRepository.findAll().stream()
                .map(client -> new ClientResponse(client.getId(), client.getFullName(), client.getGender(), client.getStatus()))
                .toList();
    }

    @Transactional
    public void update(Long clientId, UpdateClientRequest request){
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Клиент с id = " + clientId + " не найден"));
        if (request.fullName() != null) {
            client.setFullName(request.fullName());
        }
        if (request.gender() != null) {
            client.setGender(request.gender());
        }
        if (request.status() != null) {
            client.setStatus(request.status());
        }
        clientRepository.save(client);
    }

    @Transactional
    public void delete(Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new EntityNotFoundException("Клиент с id = " + clientId + " не найден");
        }
        clientRepository.deleteById(clientId);
    }
}
