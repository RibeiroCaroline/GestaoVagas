package br.com.carolineribeiro.gestao_vagas.repository;

import br.com.carolineribeiro.gestao_vagas.modules.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
