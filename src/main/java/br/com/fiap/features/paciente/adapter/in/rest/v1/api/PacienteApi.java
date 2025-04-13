package br.com.fiap.features.paciente.adapter.in.rest.v1.api;

import br.com.fiap.features.paciente.adapter.in.rest.v1.Api;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.CriarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.response.CriarPacienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RequestMapping(path = "/paciente/v1")
public interface PacienteApi extends Api {

    @Operation(summary = "Criar um novo paciente")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    CriarPacienteResponse criarPaciente(@RequestBody CriarPacienteRequest request);

}
