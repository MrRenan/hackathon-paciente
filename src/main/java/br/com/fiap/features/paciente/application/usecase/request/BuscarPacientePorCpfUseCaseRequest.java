package br.com.fiap.features.paciente.application.usecase.request;

import lombok.Builder;

@Builder
public record BuscarPacientePorCpfUseCaseRequest(
        String cpf
) {

}