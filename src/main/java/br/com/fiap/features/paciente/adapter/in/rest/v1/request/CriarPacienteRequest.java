package br.com.fiap.features.paciente.adapter.in.rest.v1.request;

import lombok.Builder;

@Builder
public record CriarPacienteRequest(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {

}