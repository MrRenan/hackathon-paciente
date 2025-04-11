package br.com.fiap.features.paciente.domain.exception;

public class PacienteJaCadastradoException extends RuntimeException {
    public PacienteJaCadastradoException(String message) {
        super(message);
    }
}
