package br.com.fiap.features.paciente.application.mapper;

import br.com.fiap.features.paciente.application.port.request.BuscarPacientePorCpfPortRequest;
import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.response.BuscarPacientePorCpfPortResponse;
import br.com.fiap.features.paciente.application.port.response.CriarPacientePortResponse;
import br.com.fiap.features.paciente.application.usecase.request.BuscarPacientePorCpfUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.request.CriarPacienteUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.response.BuscarPacientePorCpfUseCaseResponse;
import br.com.fiap.features.paciente.application.usecase.response.CriarPacienteUseCaseResponse;
import org.mapstruct.AnnotateWith;
import org.mapstruct.AnnotateWith.Element;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@AnnotateWith(value = Component.class, elements = @Element(strings = "pacienteApplicationMapper"))
@Mapper(componentModel = "spring")
public interface PacienteApplicationMapper {

    CriarPacientePortRequest paraCriarPacientePortRequest(CriarPacienteUseCaseRequest request);

    CriarPacienteUseCaseResponse paraCriarPacienteUseCaseResponse(CriarPacientePortResponse response);

    BuscarPacientePorCpfPortRequest paraBuscarPacientePorCpfPortRequest(BuscarPacientePorCpfUseCaseRequest useCaseRequest);

    BuscarPacientePorCpfUseCaseResponse paraBuscarPacientePorCpfUseCaseResponse(BuscarPacientePorCpfPortResponse portRequest);
}
