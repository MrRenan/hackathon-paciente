package br.com.fiap.features.paciente.application.usecase;

import br.com.fiap.features.paciente.application.mapper.PacienteApplicationMapper;
import br.com.fiap.features.paciente.application.port.PacientePort;
import br.com.fiap.features.paciente.application.usecase.request.BuscarPacientePorCpfUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.request.CriarPacienteUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.response.BuscarPacientePorCpfUseCaseResponse;
import br.com.fiap.features.paciente.application.usecase.response.CriarPacienteUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("pacienteUseCase")
public class PacienteUseCase {

    private final PacienteApplicationMapper mapper;
    private final PacientePort port;

    public CriarPacienteUseCaseResponse executarCriarPaciente(CriarPacienteUseCaseRequest useCaseRequest) {
        var portRequest = mapper.paraCriarPacientePortRequest(useCaseRequest);
        var portResponse = port.criarPaciente(portRequest);
        return mapper.paraCriarPacienteUseCaseResponse(portResponse);
    }

    public BuscarPacientePorCpfUseCaseResponse executarBuscarPacientePorCpfUseCase(BuscarPacientePorCpfUseCaseRequest useCaseRequest) {
        var portRequest = mapper.paraBuscarPacientePorCpfPortRequest(useCaseRequest);
        var portResponse = port.buscarPacientePorCpf(portRequest);
        return mapper.paraBuscarPacientePorCpfUseCaseResponse(portResponse);
    }

}