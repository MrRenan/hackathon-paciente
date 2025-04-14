package br.com.fiap.features.paciente.adapter.in.rest.v1.request;

import lombok.Builder;

@Builder
public record AtualizarPacienteRequest(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {

}