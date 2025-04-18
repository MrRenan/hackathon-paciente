package br.com.fiap.features.paciente.adapter.in.rest.v1.mapper;

import br.com.fiap.features.paciente.adapter.in.rest.v1.request.CriarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.AtualizarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.response.PacienteResponse;
import br.com.fiap.features.paciente.application.usecase.request.BuscarPacientePorCpfUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.request.AtualizarPacienteUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.request.CriarPacienteUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.request.RemoverPacienteUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.response.PacienteUseCaseResponse;
import org.mapstruct.AnnotateWith;
import org.mapstruct.AnnotateWith.Element;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@AnnotateWith(value = Component.class, elements = @Element(strings = "pacienteInRestMapper"))
@Mapper(componentModel = "spring")
public interface PacienteInRestMapper {

    CriarPacienteUseCaseRequest paraCriarPacienteUseCaseRequest(CriarPacienteRequest request);

    PacienteResponse paraPacienteResponse(PacienteUseCaseResponse useCaseResponse);

    BuscarPacientePorCpfUseCaseRequest paraBuscarPacientePorCpfUseCaseRequest(String cpf);

    AtualizarPacienteUseCaseRequest paraAtualizarPacienteUseCaseRequest(AtualizarPacienteRequest request);

    RemoverPacienteUseCaseRequest paraRemoverPacienteUseCaseRequest(String cpf);
}