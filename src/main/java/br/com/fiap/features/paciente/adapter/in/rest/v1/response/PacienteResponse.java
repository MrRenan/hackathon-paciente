package br.com.fiap.features.paciente.adapter.in.rest.v1.response;

import lombok.Builder;

@Builder
public record PacienteResponse(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {
}