package br.com.fiap.features.paciente.application.usecase.request;

import lombok.Builder;

@Builder
public record AtualizarPacienteUseCaseRequest(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {

}