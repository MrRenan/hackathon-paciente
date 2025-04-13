package br.com.fiap.config.exception;

import br.com.fiap.features.paciente.domain.exception.PacienteCadastradoException;
import br.com.fiap.features.paciente.domain.exception.PacienteNaoEncontradoException;
import br.com.fiap.features.paciente.domain.exception.dto.SimpleError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PacienteCadastradoException.class)
    public ResponseEntity<SimpleError> handlePacienteCadastradoException(PacienteCadastradoException ex) {
        return ResponseEntity.status(CONFLICT).body(new SimpleError(ex.getMessage(), CONFLICT.toString()));
    }

    @ExceptionHandler(PacienteNaoEncontradoException.class)
    public ResponseEntity<SimpleError> handlePacienteNaoEncontradoException(PacienteNaoEncontradoException ex) {
        return ResponseEntity.status(NOT_FOUND).body(new SimpleError(ex.getMessage(), NOT_FOUND.toString()));
    }

}