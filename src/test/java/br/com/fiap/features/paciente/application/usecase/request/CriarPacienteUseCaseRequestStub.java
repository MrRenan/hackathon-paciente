package br.com.fiap.features.paciente.application.usecase.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CriarPacienteUseCaseRequestStub {

    protected static final Faker faker = new Faker();

    public static CriarPacienteUseCaseRequestStub novo() {
        return new CriarPacienteUseCaseRequestStub();
    }

    public CriarPacienteUseCaseRequest build() {
        return CriarPacienteUseCaseRequest.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}