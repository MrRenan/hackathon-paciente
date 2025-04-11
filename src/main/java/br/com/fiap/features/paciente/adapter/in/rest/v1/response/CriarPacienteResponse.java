package br.com.fiap.features.paciente.adapter.in.rest.v1.response;

import lombok.Builder;

@Builder
public record CriarPacienteResponse(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {
}