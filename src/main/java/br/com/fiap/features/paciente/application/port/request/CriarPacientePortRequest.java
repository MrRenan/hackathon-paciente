package br.com.fiap.features.paciente.application.port.request;

import lombok.Builder;

@Builder
public record CriarPacientePortRequest(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {

}