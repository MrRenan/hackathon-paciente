package br.com.fiap.features.paciente.adapter.in.rest.v1.api;

import br.com.fiap.features.paciente.adapter.in.rest.v1.Api;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.CriarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.response.PacienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Validated
@RequestMapping(path = "/paciente/v1")
public interface PacienteApi extends Api {

    @Operation(summary = "Criar um novo paciente")
    @PostMapping
    @ResponseStatus(CREATED)
    PacienteResponse criarPaciente(@RequestBody CriarPacienteRequest request);

    @Operation(summary = "Buscar paciente por CPF")
    @GetMapping(path = "/{cpf}")
    @ResponseStatus(OK)
    PacienteResponse buscarPacientePorCpf(@PathVariable("cpf") String cpf);

    @Operation(summary = "Listar todos os pacientes")
    @GetMapping
    @ResponseStatus(OK)
    List<PacienteResponse> listarTodosPacientes();
}