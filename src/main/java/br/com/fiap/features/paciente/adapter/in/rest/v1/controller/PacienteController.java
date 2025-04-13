package br.com.fiap.features.paciente.adapter.in.rest.v1.controller;

import br.com.fiap.features.paciente.adapter.in.rest.v1.api.PacienteApi;
import br.com.fiap.features.paciente.adapter.in.rest.v1.mapper.PacienteInRestMapper;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.CriarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.response.CriarPacienteResponse;
import br.com.fiap.features.paciente.application.usecase.PacienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PacienteController implements PacienteApi {

    private final PacienteInRestMapper mapper;
    private final PacienteUseCase useCase;

    @Override
    public CriarPacienteResponse criarPaciente(CriarPacienteRequest request) {
        var useCaseRequest = mapper.paraCriarPacienteUseCaseRequest(request);
        var useCaseResponse = useCase.executarCriarPaciente(useCaseRequest);
        return mapper.paraCriarPacienteResponse(useCaseResponse);
    }

}