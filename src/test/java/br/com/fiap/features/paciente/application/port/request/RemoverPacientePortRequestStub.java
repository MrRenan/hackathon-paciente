package br.com.fiap.features.paciente.application.port.request;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class RemoverPacientePortRequestStub {

    protected static final Faker faker = new Faker();

    public static RemoverPacientePortRequestStub novo() {
        return new RemoverPacientePortRequestStub();
    }

    public RemoverPacientePortRequest build() {
        return RemoverPacientePortRequest.builder()
                .cpf(faker.number().digits(11))
                .build();
    }

}