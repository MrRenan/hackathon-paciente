package br.com.fiap.features.paciente.adapter.in.rest.v1.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CriarPacienteRequestStub {

    protected static final Faker faker = new Faker();

    public static CriarPacienteRequestStub novo() {
        return new CriarPacienteRequestStub();
    }

    public CriarPacienteRequest build() {
        return CriarPacienteRequest.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}