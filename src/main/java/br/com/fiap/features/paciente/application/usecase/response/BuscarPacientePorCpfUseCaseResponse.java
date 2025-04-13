package br.com.fiap.features.paciente.application.usecase.response;

import lombok.Builder;

@Builder
public record BuscarPacientePorCpfUseCaseResponse(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {

}