package br.com.fiap.features.paciente.application.port.request;

import lombok.Builder;

@Builder
public record AtualizarPacientePortRequest(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {

}