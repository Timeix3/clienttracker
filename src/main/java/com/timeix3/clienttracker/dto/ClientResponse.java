package com.timeix3.clienttracker.dto;

public record ClientResponse(
        Long id,
        String fullName,
        String gender,
        String status
) {}
