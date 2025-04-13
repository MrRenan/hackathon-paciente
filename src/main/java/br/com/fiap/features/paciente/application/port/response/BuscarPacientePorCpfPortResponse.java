package br.com.fiap.features.paciente.application.port.response;

import lombok.Builder;

@Builder
public record BuscarPacientePorCpfPortResponse(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {

}