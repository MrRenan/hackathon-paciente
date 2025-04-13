package br.com.fiap.config.exception;

import br.com.fiap.features.paciente.domain.exception.PacienteCadastradoException;
import br.com.fiap.features.paciente.domain.exception.dto.SimpleError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PacienteCadastradoException.class)
    public ResponseEntity<SimpleError> handlePacienteCadastradoException(PacienteCadastradoException ex) {
        return ResponseEntity.status(CONFLICT).body(new SimpleError(ex.getMessage(), CONFLICT.toString()));
    }

}