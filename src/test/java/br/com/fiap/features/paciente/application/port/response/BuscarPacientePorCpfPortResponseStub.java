package br.com.fiap.features.paciente.application.port.response;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class BuscarPacientePorCpfPortResponseStub {

    protected static final Faker faker = new Faker();

    public static BuscarPacientePorCpfPortResponseStub novo() {
        return new BuscarPacientePorCpfPortResponseStub();
    }

    public BuscarPacientePorCpfPortResponse build() {
        return BuscarPacientePorCpfPortResponse.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}