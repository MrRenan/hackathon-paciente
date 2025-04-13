package br.com.fiap.features.paciente.domain.exception;

public class PacienteCadastradoException extends RuntimeException {

    public PacienteCadastradoException() {
        super("Paciente possui cadastro.");
    }

}