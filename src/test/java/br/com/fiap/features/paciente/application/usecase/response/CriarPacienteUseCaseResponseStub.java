package br.com.fiap.features.paciente.application.usecase.response;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CriarPacienteUseCaseResponseStub {

    protected static final Faker faker = new Faker();

    public static CriarPacienteUseCaseResponseStub novo() {
        return new CriarPacienteUseCaseResponseStub();
    }

    public CriarPacienteUseCaseResponse build() {
        return CriarPacienteUseCaseResponse.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}