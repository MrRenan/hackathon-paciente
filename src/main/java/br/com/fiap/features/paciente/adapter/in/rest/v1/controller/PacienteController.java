package br.com.fiap.features.paciente.adapter.in.rest.v1.controller;

import br.com.fiap.features.paciente.adapter.in.rest.v1.api.PacienteApi;
import br.com.fiap.features.paciente.adapter.in.rest.v1.mapper.PacienteInRestMapper;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.AtualizarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.CriarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.response.PacienteResponse;
import br.com.fiap.features.paciente.application.usecase.PacienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PacienteController implements PacienteApi {

    private final PacienteInRestMapper mapper;
    private final PacienteUseCase useCase;

    @Override
    public PacienteResponse criarPaciente(CriarPacienteRequest request) {
        var useCaseRequest = mapper.paraCriarPacienteUseCaseRequest(request);
        var useCaseResponse = useCase.executarCriarPaciente(useCaseRequest);
        return mapper.paraPacienteResponse(useCaseResponse);
    }

    @Override
    public PacienteResponse buscarPacientePorCpf(String cpf) {
        var useCaseRequest = mapper.paraBuscarPacientePorCpfUseCaseRequest(cpf);
        var useCaseResponse = useCase.executarBuscarPacientePorCpf(useCaseRequest);
        return mapper.paraPacienteResponse(useCaseResponse);
    }

    @Override
    public List<PacienteResponse> listarTodosPacientes() {
        var useCaseResponse = useCase.executarListarTodosPacientes();
        return useCaseResponse.stream().map(mapper::paraPacienteResponse).toList();
    }

    @Override
    public PacienteResponse atualizarPaciente(String cpf, AtualizarPacienteRequest request) {
        var useCaseRequest = mapper.paraAtualizarPacienteUseCaseRequest(request);
        var useCaseResponse = useCase.executarAtualizarPaciente(useCaseRequest);
        return mapper.paraPacienteResponse(useCaseResponse);
    }

}