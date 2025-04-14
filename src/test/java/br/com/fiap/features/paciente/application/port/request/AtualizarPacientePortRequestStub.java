package br.com.fiap.features.paciente.application.port.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class AtualizarPacientePortRequestStub {

    protected static final Faker faker = new Faker();

    public static AtualizarPacientePortRequestStub novo() {
        return new AtualizarPacientePortRequestStub();
    }

    public AtualizarPacientePortRequest build() {
        return AtualizarPacientePortRequest.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}