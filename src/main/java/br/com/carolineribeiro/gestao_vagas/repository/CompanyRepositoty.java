package br.com.carolineribeiro.gestao_vagas.repository;

import br.com.carolineribeiro.gestao_vagas.modules.CandidateEntity;
import br.com.carolineribeiro.gestao_vagas.modules.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepositoty extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
}
