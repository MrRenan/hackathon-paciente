package br.com.fiap.features.paciente.application.port.response;

import lombok.Builder;

@Builder
public record CriarPacientePortResponse(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {
}
