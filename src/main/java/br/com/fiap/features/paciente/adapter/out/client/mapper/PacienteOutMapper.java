package br.com.fiap.features.paciente.adapter.out.client.mapper;

import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.response.CriarPacientePortResponse;
import br.com.fiap.infra.mongodb.paciente.document.PacienteDocument;
import org.mapstruct.AnnotateWith;
import org.mapstruct.AnnotateWith.Element;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@AnnotateWith(value = Component.class, elements = @Element(strings = "pacienteOutMapper"))
@Mapper(componentModel = "spring")
public interface PacienteOutMapper {

    PacienteDocument paraPacienteDocument(CriarPacientePortRequest request);

    CriarPacientePortResponse paraCriarPacientePortResponse(PacienteDocument document);
}
