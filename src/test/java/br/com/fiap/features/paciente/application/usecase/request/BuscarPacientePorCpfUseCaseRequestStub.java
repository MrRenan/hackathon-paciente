package br.com.fiap.features.paciente.application.usecase.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class BuscarPacientePorCpfUseCaseRequestStub {

    protected static final Faker faker = new Faker();

    public static BuscarPacientePorCpfUseCaseRequestStub novo() {
        return new BuscarPacientePorCpfUseCaseRequestStub();
    }

    public BuscarPacientePorCpfUseCaseRequest build() {
        return BuscarPacientePorCpfUseCaseRequest.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}