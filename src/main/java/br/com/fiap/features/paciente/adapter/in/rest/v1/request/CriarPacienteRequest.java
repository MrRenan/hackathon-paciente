package br.com.fiap.features.paciente.adapter.in.rest.v1.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record CriarPacienteRequest(
        @NotBlank
        String nomeCompleto,
        @NotBlank
        String cpf,
        @NotBlank
        @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Data deve estar no formato dd-MM-yyyy")
        String dataNascimento,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email
) {

}