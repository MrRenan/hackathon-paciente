package br.com.fiap.infra.mongodb.paciente.repository;

import br.com.fiap.infra.mongodb.paciente.document.PacienteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteMongoDBRepository extends MongoRepository<PacienteDocument, String> {

    Optional<PacienteDocument> findByCpf(String cpf);

}