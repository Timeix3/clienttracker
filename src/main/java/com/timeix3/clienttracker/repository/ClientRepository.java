package com.timeix3.clienttracker.repository;

import com.timeix3.clienttracker.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> { }
