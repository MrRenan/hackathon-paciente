package br.com.fiap.features.paciente.application.usecase;

import br.com.fiap.features.paciente.application.mapper.PacienteApplicationMapper;
import br.com.fiap.features.paciente.application.port.PacientePort;
import br.com.fiap.features.paciente.application.usecase.request.AtualizarPacienteUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.request.BuscarPacientePorCpfUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.request.CriarPacienteUseCaseRequest;
import br.com.fiap.features.paciente.application.usecase.response.PacienteUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component("pacienteUseCase")
public class PacienteUseCase {

    private final PacienteApplicationMapper mapper;
    private final PacientePort port;

    public PacienteUseCaseResponse executarCriarPaciente(CriarPacienteUseCaseRequest useCaseRequest) {
        var portRequest = mapper.paraCriarPacientePortRequest(useCaseRequest);
        var portResponse = port.criarPaciente(portRequest);
        return mapper.paraPacienteUseCaseResponse(portResponse);
    }

    public PacienteUseCaseResponse executarBuscarPacientePorCpf(BuscarPacientePorCpfUseCaseRequest useCaseRequest) {
        var portRequest = mapper.paraBuscarPacientePorCpfPortRequest(useCaseRequest);
        var portResponse = port.buscarPacientePorCpf(portRequest);
        return mapper.paraPacienteUseCaseResponse(portResponse);
    }

    public List<PacienteUseCaseResponse> executarListarTodosPacientes() {
        var portResponse = port.listarTodosPacientes();
        return portResponse.stream().map(mapper::paraPacienteUseCaseResponse).toList();
    }

    public PacienteUseCaseResponse executarAtualizarPaciente(AtualizarPacienteUseCaseRequest useCaseRequest) {
        var portRequest = mapper.paraAtualizarPacientePortRequest(useCaseRequest);
        var portResponse = port.atualizarPaciente(portRequest);
        return mapper.paraPacienteUseCaseResponse(portResponse);
    }
}