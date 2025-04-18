package br.com.fiap.features.paciente.adapter.out.client.mapper;

import br.com.fiap.features.paciente.application.port.request.AtualizarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.response.PacientePortResponse;
import br.com.fiap.infra.mongodb.paciente.document.PacienteDocument;
import org.mapstruct.AnnotateWith;
import org.mapstruct.AnnotateWith.Element;
import org.mapstruct.Mapper;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@AnnotateWith(value = Component.class, elements = @Element(strings = "pacienteOutMapper"))
@Mapper(componentModel = "spring")
public interface PacienteOutMapper {

    PacienteDocument paraPacienteDocument(CriarPacientePortRequest request);

    PacienteDocument paraPacienteDocument(AtualizarPacientePortRequest request);

    PacientePortResponse paraPacientePortResponse(PacienteDocument document);

    default Update paraUpdate(PacienteDocument document) {
        return new Update()
                .set("nomeCompleto", document.nomeCompleto())
                .set("cpf", document.cpf())
                .set("dataNascimento", document.dataNascimento())
                .set("telefone", document.telefone())
                .set("email", document.email());
    }

}
