package br.com.fiap.features.paciente.application.usecase;

import br.com.fiap.features.paciente.application.mapper.PacienteApplicationMapper;
import br.com.fiap.features.paciente.application.port.PacientePort;
import br.com.fiap.features.paciente.application.port.response.PacientePortResponseStub;
import br.com.fiap.features.paciente.application.usecase.request.AtualizarPacienteUseCaseRequestStub;
import br.com.fiap.features.paciente.application.usecase.request.BuscarPacientePorCpfUseCaseRequestStub;
import br.com.fiap.features.paciente.application.usecase.request.CriarPacienteUseCaseRequestStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mapstruct.factory.Mappers.getMapper;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Cliente / Cliente UseCase")
class PacienteUseCaseTest {

    @InjectMocks
    private PacienteUseCase useCase;
    @Mock
    private PacientePort port;
    @Spy
    private PacienteApplicationMapper mapper = getMapper(PacienteApplicationMapper.class);

    @Nested
    @DisplayName("Caso de uso de criar paciente")
    class ExecutarCriarPaciente {

        @Test
        @DisplayName("Deve executar caso de uso de criar paciente com sucesso")
        void test01() {
            // ASSETS
            var useCaseRequest = CriarPacienteUseCaseRequestStub.novo().build();
            var portResponse = PacientePortResponseStub.novo().build();
            when(port.criarPaciente(any())).thenReturn(portResponse);
            // ACTION
            var result = useCase.executarCriarPaciente(useCaseRequest);
            // ASSERTIONS
            assertThat(result).usingRecursiveComparison().isEqualTo(portResponse);
            verify(mapper).paraPacienteUseCaseResponse(portResponse);
            verify(mapper).paraCriarPacientePortRequest(useCaseRequest);
        }

    }

    @Nested
    @DisplayName("Caso de uso de buscar paciente por CPF")
    class ExecutarBuscarPacientePorCpfUseCase {

        @Test
        @DisplayName("Deve executar caso de uso de buscar paciente por CPF com sucesso")
        void test01() {
            // ASSETS
            var useCaseRequest = BuscarPacientePorCpfUseCaseRequestStub.novo().build();
            var portResponse = PacientePortResponseStub.novo().build();
            when(port.buscarPacientePorCpf(any())).thenReturn(portResponse);
            // ACTION
            var result = useCase.executarBuscarPacientePorCpf(useCaseRequest);
            // ASSERTIONS
            assertThat(result).usingRecursiveComparison().isEqualTo(portResponse);
            verify(mapper).paraPacienteUseCaseResponse(portResponse);
            verify(mapper).paraBuscarPacientePorCpfPortRequest(useCaseRequest);
        }

    }

    @Nested
    @DisplayName("Caso de uso de listar todos os pacientes")
    class ExecutarListarTodosPacientesUseCase {

        @Test
        @DisplayName("Deve executar caso de uso de listar todos os pacientes com sucesso")
        void test01() {
            // ASSETS
            var portResponse = List.of(PacientePortResponseStub.novo().build());
            when(port.listarTodosPacientes()).thenReturn(portResponse);
            // ACTION
            var result = useCase.executarListarTodosPacientes();
            // ASSERTIONS
            assertThat(result).usingRecursiveComparison().isEqualTo(portResponse);
            verify(mapper, times(portResponse.size())).paraPacienteUseCaseResponse(any());
        }

    }

    @Nested
    @DisplayName("Caso de uso de atualizar paciente")
    class ExecutarAtualizarPaciente {

        @Test
        @DisplayName("Deve executar caso de uso de atualizar paciente com sucesso")
        void test01() {
            // ASSETS
            var useCaseRequest = AtualizarPacienteUseCaseRequestStub.novo().build();
            var portResponse = PacientePortResponseStub.novo().build();
            when(port.atualizarPaciente(any())).thenReturn(portResponse);
            // ACTION
            var result = useCase.executarAtualizarPaciente(useCaseRequest);
            // ASSERTIONS
            assertThat(result).usingRecursiveComparison().isEqualTo(portResponse);
            verify(mapper).paraPacienteUseCaseResponse(portResponse);
            verify(mapper).paraAtualizarPacientePortRequest(useCaseRequest);
        }

    }

}