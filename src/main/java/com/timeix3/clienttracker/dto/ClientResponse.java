package com.timeix3.clienttracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClientResponse(
        @NotNull(message = "id обязателен")
        Long id,
        @NotBlank(message = "ФИО обязательно")
        String fullName,
        @Size(max = 1, message = "длина gender не должна превышать 1")
        String gender,
        @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "статус должен быть ACTIVE или INACTIVE")
        String status
) {}
