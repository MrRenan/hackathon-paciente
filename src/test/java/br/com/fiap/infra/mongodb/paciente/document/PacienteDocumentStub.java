package br.com.fiap.infra.mongodb.paciente.document;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PacienteDocumentStub {

    protected static final Faker faker = new Faker();

    public static PacienteDocumentStub novo() {
        return new PacienteDocumentStub();
    }

    public PacienteDocument build() {
        return PacienteDocument.builder()
                .cpf(faker.number().digits(11))
                .dataNascimento(faker.date().birthday().toString())
                .email(faker.internet().emailAddress())
                .nomeCompleto(faker.name().fullName())
                .build();
    }

}