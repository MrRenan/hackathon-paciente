package br.com.fiap.infra.mongodb.paciente.document;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "paciente")
public record PacienteDocument(
        String nomeCompleto,
        String cpf,
        String dataNascimento,
        String telefone,
        String email
) {
}
