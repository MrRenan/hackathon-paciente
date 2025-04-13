package br.com.fiap.features.paciente.domain.exception.dto;

import lombok.Builder;

@Builder
public record SimpleError (
        String message,
        String code
) {
}
