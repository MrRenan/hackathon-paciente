package br.com.fiap.features.paciente.application.usecase;

import br.com.fiap.features.paciente.adapter.in.rest.v1.response.CriarPacienteResponse;
import br.com.fiap.features.paciente.application.mapper.PacienteApplicationMapper;
import br.com.fiap.features.paciente.application.port.PacientePort;
import br.com.fiap.features.paciente.application.usecase.request.CriarPacienteUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.response.CriarPacienteUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("pacienteUseCase")
public class PacienteUseCase {

    private final PacienteApplicationMapper mapper;
    private final PacientePort port;

    public CriarPacienteUseCaseResponse executarCriarPaciente(CriarPacienteUseCaseRequest useCaseRequest) {
        var criarPacientePortRequest = mapper.paraCriarPacientePortRequest(useCaseRequest);
        var criarPacienteResponse = port.criarPaciente(criarPacientePortRequest);
        return mapper.paraCriarPacienteUseCaseResponse(criarPacienteResponse);
    }
}
