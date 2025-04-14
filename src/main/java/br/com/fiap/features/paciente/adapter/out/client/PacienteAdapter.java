package br.com.fiap.features.paciente.adapter.out.client;

import br.com.fiap.features.paciente.adapter.out.client.mapper.PacienteOutMapper;
import br.com.fiap.features.paciente.application.port.PacientePort;
import br.com.fiap.features.paciente.application.port.request.AtualizarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.request.BuscarPacientePorCpfPortRequest;
import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequest;
import br.com.fiap.features.paciente.application.port.request.RemoverPacientePortRequest;
import br.com.fiap.features.paciente.application.port.response.PacientePortResponse;
import br.com.fiap.features.paciente.domain.exception.PacienteCadastradoException;
import br.com.fiap.features.paciente.domain.exception.PacienteNaoEncontradoException;
import br.com.fiap.infra.mongodb.paciente.document.PacienteDocument;
import br.com.fiap.infra.mongodb.paciente.repository.PacienteMongoDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@RequiredArgsConstructor
@Component("pacienteAdapter")
public class PacienteAdapter implements PacientePort {

    private final PacienteOutMapper mapper;
    private final PacienteMongoDBRepository repository;
    private final MongoTemplate mongoTemplate;

    @Override
    public PacientePortResponse criarPaciente(CriarPacientePortRequest request) {

        var pacienteDocument = mapper.paraPacienteDocument(request);
        var buscarPacientePorCpf = buscarPorCpf(request.cpf());
        if (buscarPacientePorCpf.isPresent()) {
            throw new PacienteCadastradoException();
        } else {
            var pacienteCriado = criarPaciente(pacienteDocument);
            return mapper.paraPacientePortResponse(pacienteCriado);
        }

    }

    @Override
    public PacientePortResponse buscarPacientePorCpf(BuscarPacientePorCpfPortRequest portRequest) {

        var pacienteDocument = buscarPorCpf(portRequest.cpf());
        if (pacienteDocument.isPresent()) {
            return mapper.paraPacientePortResponse(pacienteDocument.get());
        } else {
            throw new PacienteNaoEncontradoException();
        }

    }

    @Override
    public List<PacientePortResponse> listarTodosPacientes() {

        var todosPacientesDocument = listarTodos();
        return todosPacientesDocument.stream().map(mapper::paraPacientePortResponse).toList();

    }

    @Override
    public PacientePortResponse atualizarPaciente(AtualizarPacientePortRequest portRequest) {
        var pacienteAtualizado = atualizarPaciente(mapper.paraPacienteDocument(portRequest));
        return mapper.paraPacientePortResponse(pacienteAtualizado);
    }

    @Override
    public void removerPaciente(RemoverPacientePortRequest portRequest) {
        var contagemPacienteRemovido = mongoTemplate.remove(
                        query(where("cpf").is(portRequest.cpf())),
                        PacienteDocument.class)
                .getDeletedCount();

        if (contagemPacienteRemovido == 0) {
            throw new PacienteNaoEncontradoException();
        }
    }

    private PacienteDocument atualizarPaciente(PacienteDocument document) {

        var update = mapper.paraUpdate(document);

        var pacienteAtualizado = mongoTemplate.findAndModify(
                query(where("cpf").is(document.cpf())),
                update,
                FindAndModifyOptions.options().returnNew(true),
                PacienteDocument.class
        );

        if (pacienteAtualizado == null) {
            throw new PacienteNaoEncontradoException();
        }

        return pacienteAtualizado;

    }

    private PacienteDocument criarPaciente(PacienteDocument document) {
        return repository.save(document);
    }

    private Optional<PacienteDocument> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    private List<PacienteDocument> listarTodos() {
        return repository.findAll();
    }

}