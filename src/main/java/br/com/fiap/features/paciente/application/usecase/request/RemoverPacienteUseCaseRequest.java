package br.com.fiap.features.paciente.application.usecase.request;

import lombok.Builder;

@Builder
public record RemoverPacienteUseCaseRequest(
        String cpf
) {

}