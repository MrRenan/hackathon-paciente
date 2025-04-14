package br.com.fiap.features.paciente.application.usecase.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class AtualizarPacienteUseCaseRequestStub {

    protected static final Faker faker = new Faker();

    public static AtualizarPacienteUseCaseRequestStub novo() {
        return new AtualizarPacienteUseCaseRequestStub();
    }

    public AtualizarPacienteUseCaseRequest build() {
        return AtualizarPacienteUseCaseRequest.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}