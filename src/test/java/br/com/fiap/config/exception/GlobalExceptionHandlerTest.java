package br.com.fiap.config.exception;

import br.com.fiap.features.paciente.domain.exception.PacienteCadastradoException;
import br.com.fiap.features.paciente.domain.exception.PacienteNaoEncontradoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler handler;

    @Test
    @DisplayName("Deve retornar status 409 CONFLICT quando PacienteCadastradoException for lançada")
    void test01() {
        // ASSETS
        var mensagemEsperada = "Paciente possui cadastro.";
        var ex = new PacienteCadastradoException();

        // ACTION
        var response = handler.handlePacienteCadastradoException(ex);

        // ASSERTIONS
        assertAll(
                () -> assertEquals(CONFLICT, response.getStatusCode()),
                () -> assertEquals(mensagemEsperada, Objects.requireNonNull(response.getBody()).message()),
                () -> assertEquals(CONFLICT.toString(), Objects.requireNonNull(response.getBody()).code())
        );
    }

    @Test
    @DisplayName("Deve retornar status 404 NOT FOUND quando PacienteNaoEncontradoException for lançada")
    void test02() {
        // ASSETS
        var mensagemEsperada = "Paciente não encontrado.";
        var ex = new PacienteNaoEncontradoException();

        // ACTION
        var response = handler.handlePacienteNaoEncontradoException(ex);

        // ASSERTIONS
        assertAll(
                () -> assertEquals(NOT_FOUND, response.getStatusCode()),
                () -> assertEquals(mensagemEsperada, Objects.requireNonNull(response.getBody()).message()),
                () -> assertEquals(NOT_FOUND.toString(), Objects.requireNonNull(response.getBody()).code())
        );
    }

}