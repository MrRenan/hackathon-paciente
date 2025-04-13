package br.com.fiap.features.paciente.application.port.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CriarPacientePortRequestStub {

    protected static final Faker faker = new Faker();

    public static CriarPacientePortRequestStub novo() {
        return new CriarPacientePortRequestStub();
    }

    public CriarPacientePortRequest build() {
        return CriarPacientePortRequest.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}