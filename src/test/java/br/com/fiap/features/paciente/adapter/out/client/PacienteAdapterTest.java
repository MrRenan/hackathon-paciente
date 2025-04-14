package br.com.fiap.features.paciente.adapter.out.client;

import br.com.fiap.features.paciente.adapter.out.client.mapper.PacienteOutMapper;
import br.com.fiap.features.paciente.application.port.request.AtualizarPacientePortRequestStub;
import br.com.fiap.features.paciente.application.port.request.BuscarPacientePorCpfPortRequestStub;
import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequestStub;
import br.com.fiap.features.paciente.domain.exception.PacienteCadastradoException;
import br.com.fiap.features.paciente.domain.exception.PacienteNaoEncontradoException;
import br.com.fiap.infra.mongodb.paciente.document.PacienteDocument;
import br.com.fiap.infra.mongodb.paciente.document.PacienteDocumentStub;
import br.com.fiap.infra.mongodb.paciente.repository.PacienteMongoDBRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mapstruct.factory.Mappers.getMapper;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteAdapterTest {

    @InjectMocks
    private PacienteAdapter adapter;
    @Mock
    private PacienteMongoDBRepository repository;
    @Mock
    private MongoTemplate mongoTemplate;
    @Spy
    private PacienteOutMapper mapper = getMapper(PacienteOutMapper .class);

    @Nested
    @DisplayName("Porta de criar paciente")
    class CriarPaciente {

        @Test
        @DisplayName("Deve executar porta de criar paciente com sucesso")
        void test01() {
            // ASSETS
            var request = CriarPacientePortRequestStub.novo().build();
            var document = PacienteDocumentStub.novo().build();
            when(repository.findByCpf(any())).thenReturn(Optional.empty());
            when(repository.save(any())).thenReturn(document);

            // ACTION
            var result = adapter.criarPaciente(request);

            // ASSERTIONS
            assertThat(result).usingRecursiveComparison().isEqualTo(document);
            verify(mapper).paraPacienteDocument(request);
            verify(mapper).paraPacientePortResponse(document);

        }

        @Test
        @DisplayName("Deve executar porta de criar paciente com erro, quando paciente ja existir")
        void test02() {
            // ASSETS
            var request = CriarPacientePortRequestStub.novo().build();
            var document = PacienteDocumentStub.novo().build();
            when(repository.findByCpf(any())).thenReturn(Optional.of(document));

            // ACTION & ASSERTIONS
            assertThrows(PacienteCadastradoException.class, () -> adapter.criarPaciente(request));
            verify(mapper).paraPacienteDocument(request);

        }

    }

    @Nested
    @DisplayName("Porta de buscar paciente por CPF")
    class BuscarPacientePorCpf {

        @Test
        @DisplayName("Deve executar porta de buscar paciente por CPF com sucesso")
        void test01() {
            // ASSETS
            var request = BuscarPacientePorCpfPortRequestStub.novo().build();
            var document = PacienteDocumentStub.novo().build();
            when(repository.findByCpf(any())).thenReturn(Optional.of(document));

            // ACTION
            var result = adapter.buscarPacientePorCpf(request);

            // ASSERTIONS
            assertThat(result).usingRecursiveComparison().isEqualTo(document);
            verify(mapper).paraPacientePortResponse(document);

        }

        @Test
        @DisplayName("Deve executar porta de criar paciente com erro, quando paciente ja existir")
        void test02() {
            // ASSETS
            var request = BuscarPacientePorCpfPortRequestStub.novo().build();
            when(repository.findByCpf(any())).thenReturn(Optional.empty());

            // ACTION & ASSERTIONS
            assertThrows(PacienteNaoEncontradoException.class, () -> adapter.buscarPacientePorCpf(request));

        }

    }

    @Nested
    @DisplayName("Porta de listar todos pacientes")
    class ListarTodosPacientes {

        @Test
        @DisplayName("Deve executar porta de listar todos pacientes com sucesso")
        void test01() {
            // ASSETS
            var document = List.of(PacienteDocumentStub.novo().build());
            when(repository.findAll()).thenReturn(document);

            // ACTION
            var result = adapter.listarTodosPacientes();

            // ASSERTIONS
            assertThat(result).usingRecursiveComparison().isEqualTo(document);
            verify(mapper, times(document.size())).paraPacientePortResponse(any());

        }

    }

    @Nested
    @DisplayName("Porta de atualizar paciente")
    class AtualizarPaciente {

        @Test
        @DisplayName("Deve executar porta de atualizar paciente com sucesso")
        void test01() {
            // ASSETS
            var request = AtualizarPacientePortRequestStub.novo().build();
            var document = PacienteDocument.builder()
                    .email(request.email())
                    .cpf(request.cpf())
                    .nomeCompleto(request.nomeCompleto())
                    .dataNascimento(request.dataNascimento())
                    .build();
            when(mongoTemplate.findAndModify(
                    any(Query.class),
                    any(Update.class),
                    any(FindAndModifyOptions.class),
                    eq(PacienteDocument.class)
            )).thenReturn(document);

            // ACTION
            var result = adapter.atualizarPaciente(request);

            // ASSERTIONS
            assertThat(result).usingRecursiveComparison().isEqualTo(document);
            verify(mapper).paraPacienteDocument(request);
            verify(mapper).paraPacientePortResponse(document);
            verify(mapper).paraUpdate(document);

        }

        @Test
        @DisplayName("Deve executar porta de atualizar paciente com erro, quando paciente não for encontrado")
        void test02() {
            // ASSETS
            var request = AtualizarPacientePortRequestStub.novo().build();
            when(mongoTemplate.findAndModify(
                    any(Query.class),
                    any(Update.class),
                    any(FindAndModifyOptions.class),
                    eq(PacienteDocument.class)
            )).thenReturn(null);

            // ACTION & ASSERTIONS
            assertThrows(PacienteNaoEncontradoException.class, () -> adapter.atualizarPaciente(request));

        }

    }

}