package com.timeix3.clienttracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateClientRequest(
        @NotBlank(message = "ФИО обязательно")
        String fullName,
        @Size(max = 1, message = "длина gender не должна превышать 1")
        String gender
) {}
