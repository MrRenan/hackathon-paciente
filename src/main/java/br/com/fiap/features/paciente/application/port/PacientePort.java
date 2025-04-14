package br.com.fiap.features.paciente.application.port;

import br.com.fiap.features.paciente.application.port.request.AtualizarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.request.BuscarPacientePorCpfPortRequest;
import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.response.PacientePortResponse;

import java.util.List;

public interface PacientePort {

    PacientePortResponse criarPaciente(CriarPacientePortRequest request);

    PacientePortResponse buscarPacientePorCpf(BuscarPacientePorCpfPortRequest portRequest);

    List<PacientePortResponse> listarTodosPacientes();

    PacientePortResponse atualizarPaciente(AtualizarPacientePortRequest portRequest);
}
