package br.com.fiap.features.paciente.adapter.out.client;

import br.com.fiap.features.paciente.adapter.out.client.mapper.PacienteOutMapper;
import br.com.fiap.features.paciente.application.port.PacientePort;
import br.com.fiap.features.paciente.application.port.request.BuscarPacientePorCpfPortRequest;
import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.response.BuscarPacientePorCpfPortResponse;
import br.com.fiap.features.paciente.application.port.response.CriarPacientePortResponse;
import br.com.fiap.features.paciente.domain.exception.PacienteCadastradoException;
import br.com.fiap.features.paciente.domain.exception.PacienteNaoEncontradoException;
import br.com.fiap.infra.mongodb.paciente.document.PacienteDocument;
import br.com.fiap.infra.mongodb.paciente.repository.PacienteMongoDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component("pacienteAdapter")
public class PacienteAdapter implements PacientePort {

    private final PacienteOutMapper mapper;
    private final PacienteMongoDBRepository repository;

    @Override
    public CriarPacientePortResponse criarPaciente(CriarPacientePortRequest request) {

        var pacienteDocument = mapper.paraPacienteDocument(request);
        var buscarPacientePorCpf = buscarPorCpf(request.cpf());
        if (buscarPacientePorCpf.isPresent()) {
            throw new PacienteCadastradoException();
        } else {
            var pacienteCriado = repository.save(pacienteDocument);
            return mapper.paraCriarPacientePortResponse(pacienteCriado);
        }

    }

    @Override
    public BuscarPacientePorCpfPortResponse buscarPacientePorCpf(BuscarPacientePorCpfPortRequest portRequest) {

        var pacienteDocument = buscarPorCpf(portRequest.cpf());
        if(pacienteDocument.isPresent()) {
            return mapper.paraBuscarPacientePorCpfPortResponse(pacienteDocument.get());
        }
        else {
            throw new PacienteNaoEncontradoException();
        }

    }

    private Optional<PacienteDocument> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

}