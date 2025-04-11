package br.com.fiap.features.paciente.application.port;

import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.response.CriarPacientePortResponse;

public interface PacientePort {

    CriarPacientePortResponse criarPaciente(CriarPacientePortRequest request);
}
