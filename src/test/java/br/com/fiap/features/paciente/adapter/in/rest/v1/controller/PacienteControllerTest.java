package br.com.fiap.features.paciente.adapter.in.rest.v1.controller;

import br.com.fiap.features.paciente.adapter.in.rest.v1.mapper.PacienteInRestMapper;
import br.com.fiap.features.paciente.adapter.in.rest.v1.request.CriarPacienteRequestStub;
import br.com.fiap.features.paciente.adapter.in.rest.v1.response.CriarPacienteResponse;
import br.com.fiap.features.paciente.application.usecase.PacienteUseCase;
import br.com.fiap.features.paciente.application.usecase.response.CriarPacienteUseCaseResponseStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@ExtendWith(MockitoExtension.class)
@DisplayName("Cliente / Rest / V1 / Paciente Controller")
class PacienteControllerTest {

    private static final String BASE_URL = "/paciente/v1";

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
            BDDMockito.given(useCase.executarCriarPaciente(any())).willReturn(useCaseResponse);
            // ACTION
            var request = CriarPacienteRequestStub.novo().build();
            var result = mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                    .content(objectMapper.writeValueAsBytes(request))
                    .contentType(APPLICATION_JSON)
                    .accept(APPLICATION_JSON));
            // ASSERTIONS
            result.andExpect(MockMvcResultMatchers.status().isCreated());
            var json = result.andReturn().getResponse().getContentAsString();
            var response = objectMapper.readValue(json, CriarPacienteResponse.class);
            Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(useCaseResponse);
            verify(mapper).paraCriarPacienteUseCaseRequest(request);
            verify(mapper).paraCriarPacienteResponse(useCaseResponse);
        }

    }

}