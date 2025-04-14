package br.com.fiap.features.paciente.adapter.in.rest.v1.api;

import br.com.fiap.features.paciente.adapter.in.rest.v1.Api;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.CriarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.AtualizarPacienteRequest;
import br.com.fiap.features.paciente.adapter.in.rest.v1.response.PacienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

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

    @Operation(summary = "Atualizar dados do paciente")
    @PutMapping(path = "/{cpf}")
    @ResponseStatus(OK)
    PacienteResponse atualizarPaciente(@PathVariable("cpf") String cpf,
                                       @RequestBody AtualizarPacienteRequest request);

    @Operation(summary = "Remover paciente")
    @DeleteMapping(path = "/{cpf}")
    @ResponseStatus(NO_CONTENT)
    void removerPaciente(@PathVariable("cpf") String cpf);
}