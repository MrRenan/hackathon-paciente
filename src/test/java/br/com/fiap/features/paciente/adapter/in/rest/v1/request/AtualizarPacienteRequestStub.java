package br.com.fiap.features.paciente.adapter.in.rest.v1.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class AtualizarPacienteRequestStub {

    protected static final Faker faker = new Faker();

    public static AtualizarPacienteRequestStub novo() {
        return new AtualizarPacienteRequestStub();
    }

    public AtualizarPacienteRequest build() {
        return AtualizarPacienteRequest.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}