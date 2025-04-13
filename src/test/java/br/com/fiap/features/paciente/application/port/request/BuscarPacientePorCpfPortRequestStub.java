package br.com.fiap.features.paciente.application.port.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class BuscarPacientePorCpfPortRequestStub {

    protected static final Faker faker = new Faker();

    public static BuscarPacientePorCpfPortRequestStub novo() {
        return new BuscarPacientePorCpfPortRequestStub();
    }

    public BuscarPacientePorCpfPortRequest build() {
        return BuscarPacientePorCpfPortRequest.builder()
                .cpf(faker.number().digits(11))
                .build();
    }

}