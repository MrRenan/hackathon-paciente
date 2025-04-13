package br.com.fiap.features.paciente.adapter.out.client;

import br.com.fiap.features.paciente.adapter.out.client.mapper.PacienteOutMapper;
import br.com.fiap.features.paciente.application.port.request.CriarPacientePortRequestStub;
import br.com.fiap.features.paciente.domain.exception.PacienteCadastradoException;
import br.com.fiap.infra.mongodb.paciente.document.PacienteDocumentStub;
import br.com.fiap.infra.mongodb.paciente.repository.PacienteMongoDBRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mapstruct.factory.Mappers.getMapper;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteAdapterTest {

    @InjectMocks
    private PacienteAdapter adapter;
    @Mock
    private PacienteMongoDBRepository repository;
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
            verify(mapper).paraCriarPacientePortResponse(document);

        }

        @Test
        @DisplayName("Deve executar porta de criar paciente com erro, quando paciente ja existir")
        void test02() {
            // ASSETS
            var request = CriarPacientePortRequestStub.novo().build();
            var document = PacienteDocumentStub.novo().build();
            when(repository.findByCpf(any())).thenReturn(Optional.of(document));

            // ACTION & ASSERTIONS
            Assertions.assertThrows(PacienteCadastradoException.class, () -> adapter.criarPaciente(request));
            verify(mapper).paraPacienteDocument(request);

        }

    }

}