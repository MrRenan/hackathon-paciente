package br.com.fiap.features.paciente.adapter.in.rest.v1.mapper;

import br.com.fiap.features.paciente.adapter.in.rest.v1.request.CriarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.response.CriarPacienteResponse;
import br.com.fiap.features.paciente.application.usecase.request.CriarPacienteUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.response.CriarPacienteUseCaseResponse;
import org.mapstruct.AnnotateWith;
import org.mapstruct.AnnotateWith.Element;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@AnnotateWith(value = Component.class, elements = @Element(strings = "pacienteInRestV1Mapper"))
@Mapper(componentModel = "spring")
public interface PacienteInRestMapper {

    CriarPacienteUseCaseRequest paraCriarPacienteUseCaseRequest(CriarPacienteRequest request);

    CriarPacienteResponse paraCriarPacienteResponse(CriarPacienteUseCaseResponse useCaseResponse);

}