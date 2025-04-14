package br.com.fiap.features.paciente.application.usecase.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class RemoverPacienteUseCaseRequestStub {

    protected static final Faker faker = new Faker();

    public static RemoverPacienteUseCaseRequestStub novo() {
        return new RemoverPacienteUseCaseRequestStub();
    }

    public RemoverPacienteUseCaseRequest build() {
        return RemoverPacienteUseCaseRequest.builder()
                .cpf(faker.number().digits(11))
                .build();
    }

}