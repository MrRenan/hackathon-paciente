package br.com.fiap.features.paciente.adapter.in.rest.v1.controller;

import br.com.fiap.features.paciente.adapter.in.rest.v1.mapper.PacienteInRestMapper;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.CriarPacienteRequestStub;
import br.com.fiap.features.paciente.adapter.in.rest.v1.response.PacienteResponse;
import br.com.fiap.features.paciente.application.usecase.PacienteUseCase;
import br.com.fiap.features.paciente.application.usecase.response.BuscarPacientePorCpfUseCaseResponseStub;
import br.com.fiap.features.paciente.application.usecase.response.CriarPacienteUseCaseResponseStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@DisplayName("Cliente / Rest / V1 / Paciente Controller")
class PacienteControllerTest {

    private static final String BASE_URL = "/paciente/v1";

    Faker faker = new Faker();

    @InjectMocks
    private PacienteController controller;
    @Spy
    private PacienteInRestMapper mapper = Mappers.getMapper(PacienteInRestMapper.class);
    @Mock
    private PacienteUseCase useCase;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
        objectMapper = new ObjectMapper();
    }

    @Nested
    @DisplayName("API de criar paciente")
    class CriarPaciente {

        @Test
        @DisplayName("Deve executar API V1 de criar paciente com sucesso")
        void test01() throws Exception {
            // ASSETS
            var useCaseResponse = CriarPacienteUseCaseResponseStub.novo().build();
            given(useCase.executarCriarPaciente(any())).willReturn(useCaseResponse);
            var request = CriarPacienteRequestStub.novo().build();
            // ACTION
            var result = mockMvc.perform(post(BASE_URL)
                    .content(objectMapper.writeValueAsBytes(request))
                    .contentType(APPLICATION_JSON)
                    .accept(APPLICATION_JSON));
            // ASSERTIONS
            result.andExpect(status().isCreated());
            var json = result.andReturn().getResponse().getContentAsString();
            var response = objectMapper.readValue(json, PacienteResponse.class);
            assertThat(response).usingRecursiveComparison().isEqualTo(useCaseResponse);
            verify(mapper).paraCriarPacienteUseCaseRequest(request);
            verify(mapper).paraPacienteResponse(useCaseResponse);
        }

    }

    @Nested
    @DisplayName("API de buscar paciente por CPF")
    class BuscarPacientePorCPF {

        @Test
        @DisplayName("Deve executar API V1 de buscar paciente por cpf com sucesso")
        void test01() throws Exception {
            // ASSETS
            var cpf = faker.number().digits(11);
            var useCaseResponse = BuscarPacientePorCpfUseCaseResponseStub.novo().build();
            given(useCase.executarBuscarPacientePorCpfUseCase(any())).willReturn(useCaseResponse);
            // ACTION
            var result = mockMvc.perform(get(BASE_URL.concat(String.format("/%s", cpf)))
                    .contentType(APPLICATION_JSON)
                    .accept(APPLICATION_JSON));
            // ASSERTIONS
            result.andExpect(status().isOk());
            var json = result.andReturn().getResponse().getContentAsString();
            var response = objectMapper.readValue(json, PacienteResponse.class);
            assertThat(response).usingRecursiveComparison().isEqualTo(useCaseResponse);
            verify(mapper).paraBuscarPacientePorCpfUseCaseRequest(cpf);
            verify(mapper).paraPacienteResponse(useCaseResponse);
        }

    }

}