package br.com.fiap.features.paciente.domain.exception;

public class PacienteNaoEncontradoException extends RuntimeException {

    public PacienteNaoEncontradoException() {
        super("Paciente não encontrado.");
    }

}