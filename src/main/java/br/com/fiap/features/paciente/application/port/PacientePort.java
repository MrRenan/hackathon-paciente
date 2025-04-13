package br.com.fiap.features.paciente.application.port;

import br.com.fiap.features.paciente.application.port.request.BuscarPacientePorCpfPortRequest;
import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.response.BuscarPacientePorCpfPortResponse;
import br.com.fiap.features.paciente.application.port.response.CriarPacientePortResponse;

public interface PacientePort {

    CriarPacientePortResponse criarPaciente(CriarPacientePortRequest request);

    BuscarPacientePorCpfPortResponse buscarPacientePorCpf(BuscarPacientePorCpfPortRequest portRequest);
}
